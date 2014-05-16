/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.business;

import ch.brinika.sportsplanner5000.domain.Team;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author simon
 * @author Andreas Briw
 */
@Stateless
@LocalBean
public class TeamEJB {
    
    @PersistenceContext(unitName = "ch.brinika_sportsplanner5000_war_1.0PU")
    EntityManager em;
    
    // Methods -------------------------------------------------------------
    //testkommentar
    public Team createTeam(Team team)
    {
        em.persist(team);
        return team;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
