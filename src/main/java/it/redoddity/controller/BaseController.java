/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;

/**
 *
 * @author madchicken
 */
public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String method = "get";

    @Autowired
    protected Validator validator;

    public BaseController() {
    }
    
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    public void index()
            throws ServletException, IOException {
        render();
    }

    protected void render(String view) throws ServletException, IOException {
        
        String controller = (String)request.getAttribute("controller");
        request.getRequestDispatcher("/WEB-INF/views/" + 
            controller + "/" + view + ".jsp").forward(request, response);
    }

    protected void render() throws ServletException, IOException {
        String action = (String)request.getAttribute("action");
        render(action);
    }
    
    protected void renderJson(Object model) throws ServletException, IOException {
        response.setStatus(200);
        response.setContentType("application/json");
        Gson gs = new Gson();
        try(PrintWriter out = response.getWriter()) {
            out.println(gs.toJson(model));
            out.flush();
        }
    }
    
    protected boolean isJson() {
        String accept = request.getHeader("accept");
        return (accept.indexOf("json") != -1);
    }
    
    protected void redirect(String controller, 
        String action) throws ServletException, IOException {
        
        if(action == null) {
            action = "index";
        }
        response.sendRedirect(request.getServletContext().getContextPath() + "/mvc/" + 
                controller + "/" + action);
    }

    protected void redirect(String controller) throws ServletException, IOException {
        redirect(controller, null);
    }

    
}
