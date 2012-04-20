/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.controller;

import it.redoddity.portfolios.dao.ProjectDAO;
import it.redoddity.portfolios.model.Project;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author madchicken
 */
@Controller(value="home")
@Scope("prototype")
public class HomeController extends ApplicationController {
    
    private static final Log log = LogFactory.getLog(HomeController.class);
    
    @Autowired
    public ProjectDAO projectDAO;
    
    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }
    
    @Override
    public void index() throws ServletException, IOException {
        try {
            int from = 0;
            int to = 10;
            try{
                from = Integer.parseInt(request.getParameter("from"));
                //to = Integer.parseInt(request.getParameter("to"));
            }catch(NumberFormatException ex){
                log.error(ex,ex);
            }
                    
            List<Project> projects =  projectDAO.findLastProjects(from, to);
            int projectsSize = projectDAO.findAll().size();
            request.setAttribute("lastProjects", projects);
            request.setAttribute("projectsSize", projectsSize);
            request.setAttribute("from", from);
            render();
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
        
}
