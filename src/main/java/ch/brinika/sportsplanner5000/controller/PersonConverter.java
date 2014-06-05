/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.controller;

import ch.brinika.sportsplanner5000.business.PersonEJB;
import ch.brinika.sportsplanner5000.domain.Person;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Simon Kaufmann
 * @author Andreas Briw
 * @author Michael Niggeler
 */
@FacesConverter("personConverter")
public class PersonConverter implements Converter{

    @EJB
    PersonEJB personEJB;
    
    /**
     * Person wird als Objekt von übergebenem String zurückgegeben.
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            //ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
            //return service.getThemes().get(Integer.parseInt(value));
            for(Person person:personEJB.findPersons())
            {
                if(person.getPersonID().equals(Integer.parseInt(value)))
                    return person;
            }
        }
        else {
            return null;
        }
        return null;
    }

    /**
     * Person ID wird als String von übergebenem Team zurückgegeben.
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
           if(value != null) {
            return String.valueOf(((Person) value).getPersonID());
        }
        else {
            return null;
        }
    }
    
}
