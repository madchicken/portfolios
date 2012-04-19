/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

/**
 *
 * @author madchicken
 */
public abstract class Model {

    private static Log log = LogFactory.getLog(Model.class);
    private String id;
    private Date createdAt;
    private Date updatedAt;

    private DataBinder dataBinder;
    
   
    
    protected Model() {
        dataBinder = new DataBinder(this);
    }

    public Model(Map<String, Object> properties) {
        fromMap(properties);
        dataBinder = new DataBinder(this);        
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    
    

    public void fromMap(Map<String, Object> properties) {
        for (String propertyName : properties.keySet()) {
            try {
                PropertyUtils.setProperty(this, propertyName, properties.get(propertyName));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            }
        }
    }

    public void bind(Map<String, String[]> params, Validator validator) {
        MutablePropertyValues mpv = new MutablePropertyValues();
        if(params != null) {
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                String name = entry.getKey();
                String[] value = entry.getValue();
                if (value != null && value.length > 0) {
                    mpv.addPropertyValue(name, value[0]);
                }
            }
        }
        getDataBinder().setValidator(validator);
        getDataBinder().bind(mpv);        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataBinder getDataBinder() {
        if(dataBinder == null)
            dataBinder = new DataBinder(this);
        return dataBinder;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Model) {
            Model m = (Model) obj;
            if(m.id == null) 
                return false;
            return  (m.id.equals(id));
        } else {
            return false;
        }
    }
}
