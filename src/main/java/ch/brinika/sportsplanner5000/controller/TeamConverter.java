/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.controller;

import ch.brinika.sportsplanner5000.business.TeamEJB;
import ch.brinika.sportsplanner5000.domain.Team;
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
@FacesConverter("teamConverter")
public class TeamConverter implements Converter{
    
    @EJB
    TeamEJB teamEJB;

    /**
     *
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
            for(Team team:teamEJB.findTeams())
            {
                if(team.getTeamID().equals(Integer.parseInt(value)))
                    return team;
            }
        }
        else {
            return null;
        }
        return null;
    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
           if(value != null) {
            return String.valueOf(((Team) value).getTeamID());
        }
        else {
            return null;
        }
    }
    
}
