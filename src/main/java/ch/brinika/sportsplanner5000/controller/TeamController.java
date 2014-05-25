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

    private Team team = new Team();
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
}
