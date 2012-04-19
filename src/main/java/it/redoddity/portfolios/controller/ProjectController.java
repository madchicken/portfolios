/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.controller;

import it.redoddity.portfolios.dao.ProjectDAO;
import it.redoddity.portfolios.model.Project;
import it.redoddity.portfolios.model.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author daniel
 */
@Scope("prototype")
@Controller(value="project")
public class ProjectController extends ApplicationController{
    
    private ProjectDAO projectDAO;

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }
    
    public void create() throws ServletException, IOException {
        render("create");
    }
    
    public void save() throws SQLException {
        User user = new User();
        user.setId("a821b1ce-aa73-4ce1-845c-6f4b4b34407a");
        user.setEmail("test@redoddity.it");
        
        Project project = new Project();
        project.bind(request.getParameterMap(), validator);
        projectDAO.create(project, user);
    }
    
}
