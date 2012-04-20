/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.dao;

import it.redoddity.dao.BaseDAO;
import it.redoddity.portfolios.model.Project;
import it.redoddity.portfolios.model.User;
import it.redoddity.utils.DatabaseConnectionInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alessandro
 */
@Repository
public class UserDAO extends BaseDAO<User> {
    private static final Log log = LogFactory.getLog(UserDAO.class);

    @Autowired
    public UserDAO(DatabaseConnectionInfo info) {
        super(User.class, info);
        User.setDao(this);
    }
    
    public User findByEmail(String email) throws SQLException {
        List<User> users = findByProperty("email", email);
        return users.size() == 1 ? users.get(0) : null;
    }
    
        public User findByNichNamel(String nickName) throws SQLException {
        List<User> users = findByProperty("nickName", nickName);
        return users.size() == 1 ? users.get(0) : null;
    }

    public List<User> findCollaboratorsForProject(Project project) throws SQLException {
        return select("select * from user join user_projects on user.id = user_projects.user_id where user_projects.project_id =?", project.getId());        
    }
    
    public boolean exists(String email) {
        try {
            return findByEmail(email) != null;
        } catch (SQLException ex) {
            log.error(ex, ex);
        }
        return false;

    }
}
