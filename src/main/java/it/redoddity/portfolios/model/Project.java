/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.portfolios.model;

import it.redoddity.model.Validatable;
import it.redoddity.portfolios.dao.ProjectDAO;
import it.redoddity.portfolios.dao.UserDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

/**
 *
 * @author madchicken
 */
public class Project extends Validatable {

    public static UserDAO userDAO;
    public static ProjectDAO projectDAO;
    private String name;
    @NotBlank
    private String description;
    @URL
    private String url;
    @URL
    private String thumbnailUrl;
    private Float rating;
    private String tags;
    private String leaderId;

    public Project(Map<String, Object> properties) {
        super(properties);

    }

    public Project(User leader) {
        super();
        this.leaderId = leader.getId();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Float getRating() {
        return rating;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
    }

    public User getLeader() {
        return userDAO.findById(leaderId);
    }

    public List<User> getCollaborators() {
        return projectDAO.findProjectCollaborators(this);
    }

    public void addCollaborator(User user) throws SQLException {
        projectDAO.addCollaborator(this, user);
    }
}
