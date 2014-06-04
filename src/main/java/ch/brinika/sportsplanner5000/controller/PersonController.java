/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ch.brinika.sportsplanner5000.controller;

import ch.brinika.sportsplanner5000.business.PersonEJB;
import ch.brinika.sportsplanner5000.business.TeamEJB;
import ch.brinika.sportsplanner5000.domain.Person;
import ch.brinika.sportsplanner5000.domain.Team;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.api.UIColumn;
import org.primefaces.event.CellEditEvent;

import org.primefaces.event.RowEditEvent;

/**
 *
 * @author simon
 */
@ViewScoped
public class PersonController implements Serializable {
    
    private Person person = new Person();
    private Team team = new Team();
    private Collection<Person> personList = new ArrayList<Person>();
    
    @EJB
    private PersonEJB personEJB;
    @EJB
    private TeamEJB teamEJB;
    
    /**
     *
     */
    public void doCreatePerson() {
        personEJB.createPerson(person);
        personList = personEJB.findPersons();
        //return "Person_created";
    }
    
    /**
     *
     */
    public void doUpdatePerson() {
        personEJB.updatePerson(person);
        personList = personEJB.findPersons();
        //return "Person_Update";
    }
    
    /**
     *
     * @param id
     */
    public void doDeletePerson(int id) {
        personEJB.deletePerson(id);
        personList = personEJB.findPersons();
        //return "Persons_deleted";
    }
    
    /**
     *
     * @param id
     */
    public void setselectedPerson(int id){
        person = personEJB.findPersonById(id);
    }
    
    /**
     *
     * @param event
     */
    public void onCellEdit(CellEditEvent event) {
        Object newValue = event.getNewValue();
        String newValueFromEdit = newValue.toString();
        
        UIColumn column =  event.getColumn();
        String columnHeader = column.getHeaderText();
        
        FacesContext context = FacesContext.getCurrentInstance();
        Person personOld = context.getApplication().evaluateExpressionGet(context, "#{anzeigen}", Person.class);
        
        if("Vorname".equals(columnHeader)){
            personOld.setPrename(newValueFromEdit);
        }
        else if("Nachname".equals(columnHeader)){
            personOld.setSurname(newValueFromEdit);
        }
        else if("Adresse".equals(columnHeader)){
            personOld.setAddress(newValueFromEdit);
        }
        else if("Telefon".equals(columnHeader)){
            personOld.setPhone(newValueFromEdit);
        }
        else if("E-Mail".equals(columnHeader)){
            personOld.setMail(newValueFromEdit);
        }
        
        personEJB.updatePerson(personOld);
        personList = personEJB.findPersons();
    }
    
    /**
     *
     * @return
     */
    public Team getTeam() {
        return team;
    }
    
    /**
     *
     * @param team
     */
    public void setTeam(Team team) {
        this.team = team;
    }
    
    /**
     *
     * @return
     */
    public Person getPerson() {
        return person;
    }
    
    /**
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;
    }
    
    /**
     *
     * @return
     */
    public Collection<Person> getPersonList() {
        personList = personEJB.findPersons();
        return personList;
    }
    
    /**
     *
     * @param personList
     */
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
    
    /**
     *
     * @return
     */
    public PersonEJB getPersonEJB() {
        return personEJB;
    }
    
    /**
     *
     * @param personEJB
     */
    public void setPersonEJB(PersonEJB personEJB) {
        this.personEJB = personEJB;
    }
}
