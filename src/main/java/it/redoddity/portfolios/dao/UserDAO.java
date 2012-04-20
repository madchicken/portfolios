/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.dao;

import it.redoddity.dao.BaseDAO;
import it.redoddity.portfolios.model.User;
import it.redoddity.utils.DatabaseConnectionInfo;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Autowired
    public UserDAO(DatabaseConnectionInfo info) {
        super(User.class, info);
        User.setDao(this);
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
    
    public User findByEmail(String email, String id) {
        try {
            List<Map<String, Object>> results = select("select * from "+
                    getTableName()+" where email = ? and id <> ?", email, id);

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

    public boolean exists(String email, String id) {
        return findByEmail(email, id) != null;
    }
    
        public List<User> findAll() {
        try {
            List<Map<String, Object>> results = select("select * from " + getTableName() + 
                    "  order by nickName asc");

            List<User> users = new ArrayList<>();

            for (Map<String, Object> map : results) {
                User user = new User(map);
                users.add(user);
            }

            return users;

        } catch (SQLException sqle) {
            return null;
        }
    }
}
