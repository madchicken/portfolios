/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.model;

import it.redoddity.dao.BaseDAO;
import it.redoddity.model.Validatable;
import it.redoddity.portfolios.dao.ProjectDAO;
import it.redoddity.portfolios.dao.UserDAO;
import java.util.Date;
import java.util.Map;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author madchicken
 */
public class User extends Validatable {
    protected static UserDAO dao;
    
    public static void setDao(BaseDAO dao) {
        User.dao = (UserDAO)dao;
    }

    public static BaseDAO getDao() {
        return dao;
    }
    
    private String firstName;
    
    private String lastName;
    
    @NotBlank
    private String nickName;

    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    @Length(min=5, max=10)
    private String password;

    private Date loginAt;

    public User() {
        super();
    }

    public User(Map<String, Object> properties) {
        super(properties);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Date loginAt) {
        this.loginAt = loginAt;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }
    
    

    
}
