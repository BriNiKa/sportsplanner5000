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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author simon
 */
public class PersonController {

    private Person person = new Person();
    private Team team = new Team();
    private Collection<Person> personList = new ArrayList<Person>();

    @EJB
    private PersonEJB personEJB;
    @EJB
    private TeamEJB teamEJB;

    public void doCreatePerson() {
        personEJB.createPerson(person);
        personList = personEJB.findPersons();
        //return "Person_created";
    }

    public void doUpdatePerson() {
        personEJB.updatePerson(person);
        personList = personEJB.findPersons();
        //return "Person_Update";
    }

    public void doDeletePerson(int id) {
        personEJB.deletePerson(id);
        personList = personEJB.findPersons();
        //return "Persons_deleted";
    }

    public void showMember() {
        personList = teamEJB.getTeamMember(team);

    }
    
    public void setselectedPerson(long id){
    
        person = personEJB.findPersonById(id);
    }
    
    public void onRowEdit(RowEditEvent event) {
        //FacesMessage msg = new FacesMessage("Car Edited", ((Person) event.getObject()).getPersonID());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        //FacesMessage msg = new FacesMessage("Edit Cancelled", ((Person) event.getObject()).getPersonID());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }

     public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Collection<Person> getPersonList() {
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
