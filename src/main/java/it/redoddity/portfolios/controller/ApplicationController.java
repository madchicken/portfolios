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

    protected User getCurrentUser() throws SQLException {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            Cookie cookie = ServletUtils.getCookieByName(request, "portfolios.userid");
            if (cookie != null) {
                user = userDAO.findById(cookie.getValue());
            }
        }
        return user;
    }
    
}
