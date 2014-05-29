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
 * @author Michael
 */
public class MemberController {
    
    private Person person = new Person();
    private Team team = new Team();
    private Collection<Person> memberList = new ArrayList<>();

    @EJB
    private PersonEJB personEJB;
    @EJB
    private TeamEJB teamEJB;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Collection<Person> getMemberList() {
        return memberList;
    }

    public void setMemberList(Collection<Person> memberList) {
        this.memberList = memberList;
    }

    public TeamEJB getTeamEJB() {
        return teamEJB;
    }

    public void setTeamEJB(TeamEJB teamEJB) {
        this.teamEJB = teamEJB;
    }
    public void addNewMember(Person person) {
        getMemberList().add(person);
        //team.setPersonCollection(memberList);
        team.setPersonCollection(memberList);
        teamEJB.updateTeam(team);
        //teamEJB.findTeamById(team.getTeamID()).setPersonCollection(memberList);
    }

}
