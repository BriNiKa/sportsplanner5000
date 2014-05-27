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
import javax.ejb.EJB;

/**
 *
 * @author Andreas
 */
public class MemberController {
    
    private Person person = new Person();
    private Team team = new Team();
    private Collection<Person> memberList = new ArrayList<Person>();

    @EJB
    private PersonEJB personEJB;
    @EJB
    private TeamEJB teamEJB;

    public void showMember() {
        memberList = teamEJB.getTeamMember(team);

    }
    
    public void setselectedPerson(long id){
    
        person = personEJB.findPersonById(id);
    }
    
    public void addPerson(){
        personEJB.createPerson(person);
        memberList = personEJB.findPersons();
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
        memberList = personEJB.findPersons();
        return memberList;
    }

    public void setPersonList(List<Person> personList) {
        this.memberList = personList;
    }

    public PersonEJB getPersonEJB() {
        return personEJB;
    }

    public void setPersonEJB(PersonEJB personEJB) {
        this.personEJB = personEJB;
    }
}
