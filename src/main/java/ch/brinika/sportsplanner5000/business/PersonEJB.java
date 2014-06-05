/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.business;

import ch.brinika.sportsplanner5000.domain.Person;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Simon Kaufmann
 * @author Andreas Briw
 * @author Michael Niggeler
 */
@Stateless
@LocalBean
public class PersonEJB {
    
    @PersistenceContext(unitName = "ch.brinika_sportsplanner5000_war_1.0PU")
    EntityManager em;
    
    // Methods -------------------------------------------------------------

    /**
     * Gibt eine List der vorhandenen Personen zurück
     * @return
     */
        public List<Person> findPersons()
    {
        TypedQuery<Person> query = em.createNamedQuery("Person.findAll", Person.class);
        return query.getResultList();
    }
    
    /**
     * Gibt eine Person mit der bestimmten ID zurück
     * @param id
     * @return
     */
    public Person findPersonById(int id) {
        return em.find(Person.class, id);
    }
    
    /**
     * Speichert die Person in der Datenbank und gibt sie zurück
     * @param person
     * @return
     */
    public Person createPerson(Person person)
    {
        em.persist(person);
        return person;
    }
    
    /**
     * Löscht die Person mit der bestimmten ID aus der Datenbank
     * @param id
     * @return
     */
    public String deletePerson(int id)
    {
        Person person = em.find(Person.class, id);
        em.remove(em.merge(person));
        return ("Person deleted");
    }

    /**
     * Aktualisiert die Person in der Datenbank
     * @param person
     * @return
     */
    public Person updatePerson(Person person)
    {
        return em.merge(person);
    }
}
