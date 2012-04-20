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
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author madchicken
 */
@Repository
public class ProjectDAO extends BaseDAO<Project> {

    private UserDAO userDAO;
    private static final Log log = LogFactory.getLog(ProjectDAO.class);
    
    @Autowired
    public ProjectDAO(DatabaseConnectionInfo db) {
        super(Project.class, db);
        Project.setDao(this);
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public List<Project> findUserProjects(User user) {
        try {
            return select("SELECT * FROM project WHERE id IN (select project_id from user_projects where user_id = ?)", user.getId());
        } catch (SQLException ex) {
            log.error(ex, ex);
        }
        return null;
    }

    public List<Project> findLastProjects(int from,int to){
        try {
            return select("select * from project order by updatedAt desc limit "+from+","+to);
        } catch (SQLException ex) {
            log.error(ex, ex);
        }
        return null;
    }
    
    public List<User> findProjectCollaborators(Project project){
        try {
            return userDAO.findCollaboratorsForProject(project);
        } catch (SQLException ex) {
            log.error(ex, ex);
        }
        return null;
     
    }
    
    @Override
    public void create(Project project) throws SQLException{
        super.create(project);
        execute("insert into user_projects(user_id, project_id) values(?,?)", 
                ((Project)project).getLeaderId() , project.getId());
    }
    
    public void addCollaborator(Project project, User user) throws SQLException{
        execute("insert into user_projects(user_id, project_id) values(?,?)", 
                user.getId() , project.getId());
    }
    
    public User findLeaderById(String leaderId) {
        try {
            return userDAO.findById(leaderId);
        } catch (SQLException ex) {
            log.error(ex, ex);
        }
        return null;
    }
    
    public Project findByName(String name) {
        try {
            List<Project> projects = findByProperty("name", name);
            return projects.size() == 1 ? projects.get(0) : null;
        } catch (SQLException ex) {
            log.error(ex, ex);
        }
        return null;
    }
    
    
    public boolean exists(Project project) {
        return findByName(project.getName()) != null;
    }

}
