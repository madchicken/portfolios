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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author madchicken
 */
@Controller(value="login")
@Scope("prototype")
public class LoginController extends BaseController {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void login() throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            
            User user = userDAO.findByEmail(email);
            
            if(user != null && user.getPassword().equals(password)) {
                
                user.setLoginAt(new Date());
                try {
                    userDAO.update(user);
                } catch (SQLException sqle) {
                    throw new ServletException(sqle);
                }
                
                Cookie c = new Cookie("portfolios.userid", user.getId());
                c.setPath("/");
                c.setMaxAge(60*60*24*265);
                response.addCookie(c);
                request.getSession().setAttribute("user", user);
                redirect("home");
            } else {
                request.setAttribute("error", "Email or password are wrong!");
                render("index");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
