/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.business;

import ch.brinika.sportsplanner5000.domain.Place;
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
public class PlaceEJB {
    
    @PersistenceContext(unitName = "ch.brinika_sportsplanner5000_war_1.0PU")
    EntityManager em;
    
    // Methods -------------------------------------------------------------
    public List<Place> findPlaces(){
        return em.createNamedQuery("Place.findAll").getResultList();
    }
    
    public Place createPlace(Place place)
    {
        em.persist(place);
        return place;
    }
    
    public String deletePlace(String id)
    {
        Place place = em.find(Place.class, id);
        em.remove(em.merge(place));
        return ("Place deleted");
    }
    
    public String updatePlace(Place place)
    {
        em.merge(place);
        return ("Place updatet");
    }

}
