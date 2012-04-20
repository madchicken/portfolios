/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.model;

import it.redoddity.dao.BaseDAO;
import it.redoddity.model.Validatable;
import it.redoddity.portfolios.dao.VoteDAO;

/**
 *
 * @author madchicken
 */
public class Vote extends Validatable  {
    private static VoteDAO dao;
    
    public static void setDao(BaseDAO dao) {
        Vote.dao = (VoteDAO)dao;
    }

    public static BaseDAO getDao() {
        return Vote.dao;
    }

    private Integer value;
    private String userId;
    private String projectId;

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() {
        return projectId;
    }
    
    
    
    
    
}
