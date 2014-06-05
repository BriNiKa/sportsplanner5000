/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.business;

import ch.brinika.sportsplanner5000.domain.Event;
import java.util.List;
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
public class EventEJB {
    
    @PersistenceContext(unitName = "ch.brinika_sportsplanner5000_war_1.0PU")
    EntityManager em;
    
     // Methods -------------------------------------------------------------

    /**
     * Gibt eine List der vorhandenen Events zurück
     * @return
     */
        public List<Event> findEvents(){
        return em.createNamedQuery("Event.findAll").getResultList();
    }
    
    /**
     * Speichert den Event in der Datenbank und gibt ihn zurück
     * @param event
     * @return
     */
    public Event createEvent(Event event)
    {
        em.persist(event);
        return event;
    }
    
    /**
     * Löscht den Event mit der bestimmten ID aus der Datenbank
     * @param id
     */
    public void deleteEvent(int id)
    {
        Event event = em.find(Event.class, id);
        em.remove(em.merge(event));
        // return ("Event deleted");
    }
    
    /**
     * Aktualisiert den Event in der Datenbank
     * @param event
     * @return
     */
    public String updateEvent(Event event)
    {
        em.merge(event);
        return ("Event updatet");
    }


}
