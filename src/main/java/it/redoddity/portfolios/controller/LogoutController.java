/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.controller;

import it.redoddity.controller.BaseController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author madchicken
 */
@Controller(value="logout")
@Scope("prototype")
public class LogoutController extends BaseController {

    public void logout() throws ServletException, IOException {
        Cookie c = new Cookie("portfolios.userid", "");
        c.setPath("/");
        c.setMaxAge(0);
        response.addCookie(c);
        request.getSession().invalidate();
        redirect("login");        
    }
}
