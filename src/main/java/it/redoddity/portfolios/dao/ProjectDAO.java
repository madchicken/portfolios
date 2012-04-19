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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author madchicken
 */
@Repository
public class ProjectDAO extends BaseDAO {

    @Autowired
    public ProjectDAO(DatabaseConnectionInfo db) {
        super(Project.class, db);
    }

    public List<Project> findAll() {
        try {
            List<Map<String, Object>> projects = select("select * from Project");
            List<Project> list = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> obj = projects.get(i);
                Project project = new Project(obj);
                list.add(project);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Project> findById(String userId) {
        try {
            List<Map<String, Object>> projects = select("SELECT p.* FROM project p JOIN user_projects up ON (up.user_id = ?)", userId);
            List<Project> list = new ArrayList<>();
            for (int i = 0; i < projects.size(); i++) {
                Map<String, Object> obj = projects.get(i);
                Project project = new Project(obj);
                list.add(project);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void create(Project project, User user) throws SQLException {
        create(project);
        execute("insert into user_projects(user_id, project_id) values(?,?)",
                user.getId(), project.getId());
    }
}
