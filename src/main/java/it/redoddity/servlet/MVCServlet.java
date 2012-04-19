/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.servlet;

import it.redoddity.controller.BaseController;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author madchicken
 */
@WebServlet(name = "DispatcherServlet", urlPatterns={"/mvc/*"}, loadOnStartup=1)
public class MVCServlet extends HttpServlet {

    protected Log log = LogFactory.getLog(MVCServlet.class); 
    
    @Override
    protected void service(HttpServletRequest req, 
        HttpServletResponse resp) throws ServletException, IOException {
        
        String uri = req.getRequestURI();        
        uri = uri.substring(this.getServletContext().getContextPath().length()+"/mvc/".length());
        String[] st = uri.split("/");
        String action = "index";
        String id = null;
        String controller = "home";
        if(st.length > 1) { //controller and action are present
            controller = st[0];
            action = st[1];
            if(st.length >= 3){
                id = st[2];
            }
        } else { //only controller is present
            if(st.length > 0) { //maybe not :-)
                if("".equals(st[0]) == false)
                    controller = st[0];
            }
        }
        
        req.setAttribute("controller", controller);
        req.setAttribute("action", action);
        if(id != null) {
            req.setAttribute("id", id);
        }
        
        invokeController(req, resp);
    }

    private void invokeController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String controller = (String)request.getAttribute("controller");
        String action = (String)request.getAttribute("action");
        try {
            BaseController bc = (BaseController)context.getBean(controller);
            bc.setRequest(request);
            bc.setResponse(response);
            bc.setMethod(request.getMethod().toLowerCase());
            Method declaredMethod = bc.getClass().getMethod(action);
            declaredMethod.invoke(bc);
        } catch (IllegalAccessException | 
                NoSuchMethodException | 
                SecurityException |
                InvocationTargetException ex) {
            log.error(ex, ex);
        }
        
    }

    @Override
    public void init() throws ServletException {
        context = new ClassPathXmlApplicationContext("config.xml");
        initFixtures();
        getServletContext().setAttribute("root", 
                getServletContext().getContextPath()+"/mvc");
        getServletContext().setAttribute("contextRoot", 
                getServletContext().getContextPath());
        getServletContext().setAttribute("springContext", context);
    }

    private ApplicationContext context;

    private void initFixtures() throws ServletException {
    }
}
