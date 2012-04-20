/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.controller;

import it.redoddity.controller.BaseController;
import it.redoddity.portfolios.dao.UserDAO;
import it.redoddity.portfolios.model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author madchicken
 */
@Controller(value = "registration")
@Scope("prototype")
public class RegistrationController extends BaseController {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void index() throws ServletException, IOException {
        request.setAttribute("user", new User());
        super.index();
    }

 
    public void register()
            throws ServletException, IOException {

        User user = new User();
        if (method.equals("post")) {
          user.bind(request.getParameterMap(), validator);

            if (user.isValid()) {
                if (!user.getPassword().equals(
                        request.getParameter("passwordConfirm"))) {
                    user.addError("Passwords don't match");
                } else {
                    if (userDAO.exists(user.getEmail(), "")) {
                        user.addError("email", user.getEmail()
                                + " is already present in repository");
                    } else {
                        try {
                            userDAO.create(user);
                            response.sendRedirect(request.getContextPath());
                            return;
                        } catch (SQLException sqle) {
                            user.addError("Errore creating user: " + sqle.getMessage());
                        }
                    }
                }
            }
        }
        request.setAttribute("user", user);
        render("index");
    }
}
