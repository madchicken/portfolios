/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.utils;

import java.util.Properties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author alessandro
 */
public final class DatabaseConnectionInfo implements InitializingBean {
    
    private Properties databaseConfig;

    private String getValue(String key) {
        return databaseConfig.getProperty(key);
    }

    public DatabaseConnectionInfo(Properties config) {
        databaseConfig = config;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            Class.forName(getDriver());
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    
    public String getDriver(){
        return getValue("jdbc.driver");
    }
    
    public String getUrl(){
        return getValue("jdbc.url");
    }
    
    public String getUsername(){
        return getValue("jdbc.username");
    }
    
    public String getPassword(){
        return getValue("jdbc.password");
    }
    
}
