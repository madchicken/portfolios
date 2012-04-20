/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.controller;

import it.redoddity.portfolios.dao.ProjectDAO;
import it.redoddity.portfolios.dao.VoteDAO;
import it.redoddity.portfolios.model.Project;
import it.redoddity.portfolios.model.User;
import it.redoddity.portfolios.model.Vote;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Ale
 */
@Scope("prototype")
@Controller(value = "vote")
public class VoteController extends ApplicationController {

    private VoteDAO voteDAO;
    private ProjectDAO projectDAO;

    @Autowired
    public void setVoteDAO(VoteDAO voteDAO) {
        this.voteDAO = voteDAO;
    }

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public void vote() throws ServletException, IOException {
        try {
            String projectId = request.getParameter("projectId");
            Project project = projectDAO.findById(projectId);
            Vote v = voteDAO.getUserVoteForProject(getCurrentUser(), project);
            if (v != null) {
                v.bind(request.getParameterMap(), validator);
                voteDAO.update(v);
            } else {
                v = new Vote();
                v.bind(request.getParameterMap(), validator);
                voteDAO.create(v);
            }
            List<Vote> votes = voteDAO.findVotesByProject(project);
            int sum = 0;
            for (Vote vote : votes) {
                sum += vote.getValue();
            }
            project.setRating(new Float(sum/votes.size()));
            projectDAO.update(project);
            if (isJson()) {
                renderJson(project.getRating().toString());
            } else {
                redirect("project", "view");
            }

        } catch (SQLException ex) {
            Logger.getLogger(VoteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
