/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.dao;

import it.redoddity.model.Model;
import it.redoddity.utils.DatabaseConnectionInfo;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author alessandro
 */
public abstract class BaseDAO {

    private final Class modelClass;
    private DatabaseConnectionInfo databaseConfig;

    protected BaseDAO(Class modelClass, DatabaseConnectionInfo databaseConfig) {
        this.modelClass = modelClass;
        this.databaseConfig = databaseConfig;
    }

    protected Connection newConnection() throws SQLException {
        
        return DriverManager.getConnection(databaseConfig.getUrl(), 
                databaseConfig.getUsername(), 
                databaseConfig.getPassword());
    }

    public int execute(String query, Object... params) throws SQLException {
        try (Connection conn = newConnection()) {
            PreparedStatement prepareStatement = conn.prepareStatement(query);
            if (params != null) {
                int count = 1;
                for (Object param : params) {
                    prepareStatement.setObject(count, param);
                    count++;
                }
            }

            return prepareStatement.executeUpdate();
        } catch (SQLException sqle) {
            throw sqle;
        }
    }

    public List<Map<String, Object>> select(String query, Object... params) throws SQLException {
        try (Connection conn = newConnection()) {
            PreparedStatement prepareStatement = conn.prepareStatement(query);
            if (params != null) {
                int count = 1;
                for (Object param : params) {
                    prepareStatement.setObject(count, param);
                    count++;
                }
            }
            ResultSet rs = prepareStatement.executeQuery();

            List<Map<String, Object>> results = new ArrayList<>();

            while (rs.next()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String key = metaData.getColumnName(i);
                    Object value = rs.getObject(key);
                    row.put(key, value);
                }

                results.add(row);
            }

            return results;

        } catch (SQLException sqle) {
            throw sqle;
        }
    }

    protected void init(String[] tableFields) {
        String tableName = getTableName();
        try {
            select("select * from " + tableName);
        } catch (SQLException sqle) {
            try {

                String createStatement = "create table " + tableName + " (";
                boolean first = true;
                for (String tableField : tableFields) {
                    if (!first) {
                        createStatement += ", ";
                    }
                    createStatement += tableField;
                    first = false;
                }
                createStatement += ")";
                execute(createStatement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected String getTableName() {
        return modelClass.getSimpleName().toLowerCase();
    }

    public void update(Model model) throws SQLException {

        String tableName = getTableName();
        List<String> propertyNames=guessPropertyNames(tableName);

        String query = "update " + tableName + " set ";
        boolean first = true;
        for (String propertyName : propertyNames) {
            if (!first) {
                query += ", ";
            }
            query += propertyName+" = ?";
            first = false;
        }
        query += " where id =?";

        Object[] params = new Object[propertyNames.size()+1];
        int i = 0;
        for (String propertyName : propertyNames) {
            try {
                params[i] = PropertyUtils.getProperty(model, propertyName);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new SQLException(e);
            }
            i++;
        }
        params[i]=model.getId();

        execute(query, params);
    }

    public void create(Model model) throws SQLException {
        UUID uuid = UUID.randomUUID();
        model.setId(uuid.toString());
        model.setCreatedAt(new Date(System.currentTimeMillis()));
        model.setUpdatedAt(model.getCreatedAt());
        String tableName = getTableName();
        List<String> propertyNames = guessPropertyNames(tableName);

        String query = "insert into " + tableName + " (";
        boolean first = true;
        for (String propertyName : propertyNames) {
            if (!first) {
                query += ", ";
            }
            query += propertyName;
            first = false;
        }
        query += ") values ( ";
        first = true;
        for (int i = 0; i < propertyNames.size(); i++) {
            if (!first) {
                query += ", ";
            }
            query += "?";
            first = false;
        }
        query += ")";

        Object[] params = new Object[propertyNames.size()];
        int i = 0;
        for (String propertyName : propertyNames) {
            try {
                params[i] = PropertyUtils.getProperty(model, propertyName);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new SQLException(e);
            }
            i++;
        }

        execute(query, params);
    }

    private List<String> guessPropertyNames(String tableName) {
        List<String> propertyNames = new ArrayList<>();
        try (Connection conn = newConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from " + tableName);
            preparedStatement.setMaxRows(1);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                propertyNames.add(metaData.getColumnName(i));
            }
        } catch (SQLException sqle) {
        }
        return propertyNames;
    }
    
}
