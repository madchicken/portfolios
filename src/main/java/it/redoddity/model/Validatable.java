/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.redoddity.model;

import java.util.List;
import java.util.Map;
import org.springframework.validation.ObjectError;

/**
 *
 * @author madchicken
 */
public abstract class Validatable extends Model {
    
    public Validatable() {
    }
    
    public Validatable(Map<String, Object> properties){
        super(properties);
    }
    
    public void addError(String err) {
        getDataBinder().getBindingResult().addError(new ObjectError(this.getClass().getSimpleName(), err));
    }

    public List<ObjectError> getAllErrors() {
        if(getDataBinder().getValidator() != null) {
            getDataBinder().validate();
        }
        return getDataBinder().getBindingResult().getAllErrors();
    }

    public boolean getHasErrors() {
        return getAllErrors().isEmpty() ? false : true;
    }

    public boolean isValid() {
        return !getHasErrors();
    }
}
