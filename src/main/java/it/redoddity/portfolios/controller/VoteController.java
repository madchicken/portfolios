/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.controller;

import it.redoddity.portfolios.dao.VoteDAO;
import it.redoddity.portfolios.model.Project;
import it.redoddity.portfolios.model.User;
import it.redoddity.portfolios.model.Vote;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Ale
 */
@Scope("prototype")
@Controller(value="vote")
public class VoteController extends ApplicationController{
    
     private VoteDAO voteDAO;
    
    @Autowired
    public void setVoteDAO(VoteDAO voteDAO) {
        this.voteDAO = voteDAO;
    }
    
    public void create() throws SQLException, ServletException, IOException {
      
    }
    
    
   
    
}
