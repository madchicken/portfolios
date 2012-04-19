/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.model;

import it.redoddity.dao.BaseDAO;
import it.redoddity.model.Validatable;

/**
 *
 * @author madchicken
 */
public class Vote extends Validatable  {
    
    public static void setDao(BaseDAO dao) {
        throw new UnsupportedOperationException();
    }

    public static BaseDAO getDao() {
        throw new UnsupportedOperationException();
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
