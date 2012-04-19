/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.dao;

import it.redoddity.dao.BaseDAO;
import it.redoddity.portfolios.model.User;
import it.redoddity.utils.DatabaseConnectionInfo;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alessandro
 */
@Repository
public class UserDAO extends BaseDAO {

    private static final String[] TABLE_FIELDS = {
        "id VARCHAR( 36 ) NOT NULL PRIMARY KEY",
        "name VARCHAR( 256 ) NOT NULL",
        "email VARCHAR( 256 ) NOT NULL",
        "password VARCHAR( 256 ) NOT NULL",
        "loginAt TIMESTAMP NULL",
    };

    @Autowired
    public UserDAO(DatabaseConnectionInfo info) {
        super(User.class, info);
        init(TABLE_FIELDS);
    }
    
    public User findById(String id) {
        try {
            List<Map<String, Object>> results = select("select * from "+
                    getTableName()+" where id = ?", id);

            if (results.size() == 1) {
                Map<String, Object> result = results.get(0);
                User user = new User(result);
                return user;
            } else {
                return null;
            }

        } catch (SQLException sqle) {
            return null;
        }
    }
    
    public User findByEmail(String email) {
        try {
            List<Map<String, Object>> results = select("select * from "+
                    getTableName()+" where email = ?", email);

            if (results.size() == 1) {
                Map<String, Object> result = results.get(0);
                User user = new User(result);
                return user;
            } else {
                return null;
            }

        } catch (SQLException sqle) {
            return null;
        }
    }

    public boolean exists(String email) {
        return findByEmail(email) != null;
    }
}
