/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.controller;

import it.redoddity.controller.BaseController;
import it.redoddity.portfolios.dao.UserDAO;
import it.redoddity.portfolios.model.User;
import it.redoddity.utils.ServletUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author maurizio
 */
@Controller(value = "user")
@Scope("prototype")
public class UserController extends ApplicationController {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void index() throws ServletException, IOException {
        try {
            request.setAttribute("allUsers", userDAO.findAll());
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        render();

    }

    public void view() throws ServletException, IOException {
        try {
            String userId = (String) request.getAttribute("id");
            request.setAttribute("user", userDAO.findById(userId));
            render("view");
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void profile() throws ServletException, IOException {
        User user = null;
        try {
            user = userDAO.findById((String)request.getAttribute("id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (user == null) {
            redirect("home");
        } else {
            request.setAttribute("theUser", user);
            render();
        }
    }

    public void edit() throws ServletException, IOException {
        User user = getCurrentUser();
        request.setAttribute("user", user);
        if (user == null) {
            redirect("login");
        } else {
            render();
        }
    }

    public void update()
            throws ServletException, IOException {

        User user = new User();
        if (method.equals("post")) {
            user.bind(request.getParameterMap(), validator);

            if (user.isValid()) {
                if (!user.getPassword().equals(
                        request.getParameter("passwordConfirm"))) {
                    user.addError("Passwords don't match");
                } else {
                    try {
                        User u = userDAO.findByNichNamel(user.getNickName());
                        if (!u.equals(getCurrentUser())) {
                            user.addError("email", user.getEmail()
                                    + " is already present in repository");
                        } else {
                            user.setId(getCurrentUser().getId());
                            userDAO.update(user);
                            request.getSession().setAttribute("user", user);
                            redirect("dashboard");
                            return;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        request.setAttribute("user", user);
        render("profile");
    }
}