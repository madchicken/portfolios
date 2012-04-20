/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.utils;

import it.redoddity.portfolios.dao.ProjectDAO;
import it.redoddity.portfolios.dao.UserDAO;
import it.redoddity.portfolios.model.Project;
import it.redoddity.portfolios.model.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author madchicken
 */
@Component
public class FixturesCreator {

    private UserDAO userDAO;
    private ProjectDAO projectDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @PostConstruct
    public void create() {
        try {

            if (!userDAO.exists("test@redoddity.it", "")) {
                User user = new User();
                user.setEmail("test@redoddity.it");
                user.setPassword("password");
                
                userDAO.create(user);
                Project project = new Project(user);
                project.setName("Prima prova");
                project.setRating(5f);
                project.setTags("java, html");
                project.setDescription("Lorem ipsum dolor sit amet, "
                        + "consectetur adipiscing elit. Duis feugiat suscipit auctor. "
                        + "Quisque et tortor vel sem blandit euismod quis quis arcu. "
                        + "In ullamcorper tempor lacinia. Vestibulum ante ipsum primis "
                        + "in faucibus orci luctus et ultrices posuere cubilia Curae; "
                        + "Praesent dignissim semper tortor, sit amet vestibulum nulla "
                        + "euismod id. Duis scelerisque arcu id risus scelerisque "
                        + "vitae adipiscing dolor eleifend. Donec volutpat venenatis "
                        + "diam a vulputate. Aliquam elementum interdum nisl ac cursus.");
                projectDAO.create(project);
                user.setEmail("test2@redoddity.it");
                user.setPassword("password");
                userDAO.create(user);
                project.addCollaborator(user);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FixturesCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
