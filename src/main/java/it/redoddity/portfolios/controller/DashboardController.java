/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.controller;

import it.redoddity.portfolios.dao.ProjectDAO;
import it.redoddity.portfolios.model.Project;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author daniel
 */
@Scope("prototype")
@Controller(value="dashboard")
public class DashboardController extends ApplicationController{
    
    private ProjectDAO projectDAO;

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }
    
    @Override
    public void index() throws ServletException, IOException {
        //User user = getCurrentUser();
        List<Project> ownProjects = projectDAO.findById("a821b1ce-aa73-4ce1-845c-6f4b4b34407a");
        request.setAttribute("ownProjects", ownProjects);
        render("index");
    }
}
