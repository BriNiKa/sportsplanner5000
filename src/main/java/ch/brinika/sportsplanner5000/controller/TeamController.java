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
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

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
    @EJB
    private PersonEJB personEJB;

    /**
     *
     */
    public void doCreateTeam()
    {
        teamEJB.createTeam(team);
        teamList = teamEJB.findTeams();
        //return "Team_created";
    }
    
    /**
     *
     */
    public void doUpdateTeam()
    {
        teamEJB.updateTeam(team);
        teamList = teamEJB.findTeams();
        //return "Team_updated";
    }
     
    /**
     *
     * @param id
     */
    public void doDeleteTeam(int id)
    {
        teamEJB.deleteTeam(id);
        teamList = teamEJB.findTeams();
    }
    
        /**
     *
     * @param event
     */
    public void onCellEdit(CellEditEvent event) {
        Object newValue = event.getNewValue();
        String newValueFromEdit = newValue.toString();

        FacesContext context = FacesContext.getCurrentInstance();
        Team teamOld = context.getApplication().evaluateExpressionGet(context, "#{item}", Team.class);

        teamOld.setName(newValueFromEdit);
        
        teamEJB.updateTeam(teamOld);
        teamList = teamEJB.findTeams();
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
    public void setTeam(Team  team) {
        this.team = team;
    }

    /**
     *
     * @return
     */
    public List<Team> getTeamList() {
        teamList = teamEJB.findTeams();
        return teamList;
    }

    /**
     *
     * @param teamList
     */
    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    /**
     *
     * @return
     */
    public TeamEJB getTeamEJB() {
        return teamEJB;
    }

    /**
     *
     * @param teamEJB
     */
    public void setTeamEJB(TeamEJB teamEJB) {
        this.teamEJB = teamEJB;
    }

    /**
     *
     * @param person
     */
    public void lueg(Person person) {
//        System.out.println(person.getPrename());
    }

    /**
     *
     */
    public void lueg2() {
//        System.out.println(person.getPrename());
    }

    /**
     *
     * @param person
     */
    public void addNewMember(Person person) {
         
        Team teamToSave = teamEJB.findTeamById(this.team.getTeamID());
        
        Collection<Person> personCollection = teamToSave.getPersonCollection();
        
        personCollection.add(person);
        teamToSave.setPersonCollection(personCollection);
        teamEJB.updateTeam(teamToSave);
        team = teamToSave;
        //teamEJB.findTeamById(team.getTeamID()).setPersonCollection(memberList);
    }

    /**
     *
     * @param person
     */
    public void removeMemberFromTeam(Person person) {
        Team teamToSave = teamEJB.findTeamById(this.team.getTeamID());
        
        Collection<Person> personCollection = teamToSave.getPersonCollection();
        
        personCollection.remove(person);
        teamToSave.setPersonCollection(personCollection);
        teamEJB.updateTeam(teamToSave);
        team = teamToSave;
    }
}
