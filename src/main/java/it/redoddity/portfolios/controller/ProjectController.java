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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void newproject() throws ServletException, IOException {
        render("new");
    }
    
    public void create() throws SQLException, ServletException, IOException {
        User user = getCurrentUser();
        Project project = new Project(user);
        project.bind(request.getParameterMap(), validator);
        if(!projectDAO.exists(project)) {
            if (project.isValid()) {
                projectDAO.create(project);
                redirect("dashboard");
                return;
            }
        } else {
            project.addError("A project with the same name already exists!");
        }
        request.setAttribute("project", project);
        render("new");
    }
    
    public void view() throws ServletException, IOException {
        try {
            String projectId = (String) request.getAttribute("id");
            request.setAttribute("project", projectDAO.findById(projectId));
            render("view");
        } catch (SQLException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete() throws SQLException, ServletException, IOException {
        String projectId = (String) request.getAttribute("id");
        Project project = projectDAO.findById(projectId);
        projectDAO.delete(project);
        render("delete");
    }
    
    public void edit() throws ServletException, IOException, SQLException {
        String projectId = (String) request.getAttribute("id");
        Project project = projectDAO.findById(projectId);
        request.setAttribute("project", project);
        render("edit");
    }
    
    public void update() throws SQLException, ServletException, IOException {
        User user = getCurrentUser();
        Project project = new Project(user);
        project.bind(request.getParameterMap(), validator);
        projectDAO.update(project);
        redirect("dashboard");
    }
}
