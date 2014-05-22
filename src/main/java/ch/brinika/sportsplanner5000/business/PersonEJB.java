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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author simon
 * @author Andreas Briw
 */
@Stateless
@LocalBean
public class PersonEJB {
    
    @PersistenceContext(unitName = "ch.brinika_sportsplanner5000_war_1.0PU")
    EntityManager em;
    
    // Methods -------------------------------------------------------------
    public List<Person> findPersons()
    {
        TypedQuery<Person> query = em.createNamedQuery("Person.findAll", Person.class);
        return query.getResultList();
    }
    
    public Person findPersonById(Long id) {
        return em.find(Person.class, id);
    }
    
    public Person createPerson(Person person)
    {
        em.persist(person);
        return person;
    }
    
    public String deletePerson(int id)
    {
        Person person = em.find(Person.class, id);
        em.remove(em.merge(person));
        return ("Person deleted");
    }
    public Person updatePerson(Person person)
    {
        return em.merge(person);
    }
}
