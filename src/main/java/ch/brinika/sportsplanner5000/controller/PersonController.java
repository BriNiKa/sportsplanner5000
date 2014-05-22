/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.controller;

import ch.brinika.sportsplanner5000.business.PersonEJB;
import ch.brinika.sportsplanner5000.domain.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author simon
 */
public class PersonController {

    private Person person = new Person();
    private List<Person> personList  = new ArrayList<Person>();
    
    @EJB
    private PersonEJB personEJB;

    public String doCreatePerson()
    {
        personEJB.createPerson(person);
        personList = personEJB.findPersons();
        return "Person_created";
    }
    
     public String doUpdatePerson()
    {
        personEJB.updatePerson(person);
        personList = personEJB.findPersons();
        return "Person_Update";
    }
     
       public String doDeletePerson()
    {
        personEJB.deletePerson(person);
        personList = personEJB.findPersons();
        return "Persons_deleted";
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person  person) {
        this.person = person;
    }

    public List<Person> getPersonList() {
        personList = personEJB.findPersons();
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public PersonEJB getPersonEJB() {
        return personEJB;
    }

    public void setPersonEJB(PersonEJB personEJB) {
        this.personEJB = personEJB;
    }
}