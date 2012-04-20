/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.dao;

import it.redoddity.dao.BaseDAO;
import it.redoddity.portfolios.model.Vote;
import it.redoddity.utils.DatabaseConnectionInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author madchicken
 */
public class VoteDAO extends BaseDAO {
    @Autowired
    public VoteDAO(DatabaseConnectionInfo db) {
        super(Vote.class, db);
        Vote.setDao(this);
    }
}
