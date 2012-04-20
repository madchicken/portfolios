/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.dao;

import it.redoddity.dao.BaseDAO;
import it.redoddity.portfolios.model.Project;
import it.redoddity.portfolios.model.User;
import it.redoddity.portfolios.model.Vote;
import it.redoddity.utils.DatabaseConnectionInfo;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author madchicken
 */
@Repository
public class VoteDAO extends BaseDAO<Vote> {
    @Autowired
    public VoteDAO(DatabaseConnectionInfo db) {
        super(Vote.class, db);
        Vote.setDao(this);
    }
    
    public Vote getUserVoteForProject(User user, Project project) throws SQLException {
        List<Vote> votes = select("select * from vote where userId = ? and projectId = ?", user.getId(), project.getId());
        return (votes.size() == 1) ? votes.get(0) : null;
    }
    
}
