/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.controller;

import it.redoddity.controller.BaseController;
import it.redoddity.portfolios.dao.UserDAO;
import it.redoddity.portfolios.model.User;
import it.redoddity.utils.ServletUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author madchicken
 */
public abstract class ApplicationController extends BaseController {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    protected User getCurrentUser() {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            Cookie cookie = ServletUtils.getCookieByName(request, "portfolios.userid");
            if (cookie != null) {
                try {
                    user = userDAO.findById(cookie.getValue());
                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return user;
    }
    
}
