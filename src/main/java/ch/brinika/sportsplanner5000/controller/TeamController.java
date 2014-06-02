/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.controller;

import ch.brinika.sportsplanner5000.business.TeamEJB;
import ch.brinika.sportsplanner5000.domain.Person;
import ch.brinika.sportsplanner5000.domain.Team;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author simon
 * @author Andreas Briw
 */
public class TeamController {

    private Team team;
    private List<Team> teamList  = new ArrayList<Team>();
    
    @EJB
    private TeamEJB teamEJB;

    public void doCreateTeam()
    {
        teamEJB.createTeam(team);
        teamList = teamEJB.findTeams();
        //return "Team_created";
    }
    
     public void doUpdateTeam()
    {
        teamEJB.updateTeam(team);
        teamList = teamEJB.findTeams();
        //return "Team_updated";
    }
     
       public void doDeleteTeam(int id)
    {
        teamEJB.deleteTeam(id);
        teamList = teamEJB.findTeams();
    }
    
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team  team) {
        this.team = team;
    }

    public List<Team> getTeamList() {
        teamList = teamEJB.findTeams();
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public TeamEJB getTeamEJB() {
        return teamEJB;
    }

    public void setTeamEJB(TeamEJB teamEJB) {
        this.teamEJB = teamEJB;
    }
    public void lueg(Person person) {
        System.out.println(person.getPrename());
    }
    public void lueg2() {
//        System.out.println(person.getPrename());
    }
     public void addNewMember(Person person) {

        Collection<Person> personCollection = this.team.getPersonCollection();
        personCollection.add(person);
        
        this.team.setPersonCollection(personCollection);
        teamEJB.updateTeam(this.team);
        //teamEJB.findTeamById(team.getTeamID()).setPersonCollection(memberList);
    }
     public void removeMemberFromTeam(Person person) {
         System.out.println(person.getPrename());
        System.out.println("Bla");
        Collection<Person> personCollection = this.team.getPersonCollection();
        boolean b = personCollection.remove(person);
        System.out.println(b);
        
        this.team.setPersonCollection(personCollection);
        teamEJB.updateTeam(this.team);
        //teamEJB.findTeamById(team.getTeamID()).setPersonCollection(memberList);
    }
}
