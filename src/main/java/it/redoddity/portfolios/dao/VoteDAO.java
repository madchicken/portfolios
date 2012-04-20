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

/**
 *
 * @author madchicken
 */
public class VoteDAO extends BaseDAO<Vote> {

    @Autowired
    public VoteDAO(DatabaseConnectionInfo db) {
        super(Vote.class, db);
        Vote.setDao(this);
    }

    public List<Vote> findVotesByProject(Project project) throws SQLException {
        return select("select * from vote where project_id =?", project.getId());
    }
}
