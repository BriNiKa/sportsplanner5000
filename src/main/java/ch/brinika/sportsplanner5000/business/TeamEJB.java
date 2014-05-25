/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.business;

import ch.brinika.sportsplanner5000.domain.Person;
import ch.brinika.sportsplanner5000.domain.Team;
import java.util.Collection;
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
public class TeamEJB {
    
    @PersistenceContext(unitName = "ch.brinika_sportsplanner5000_war_1.0PU")
    EntityManager em;
    
    // Methods -------------------------------------------------------------
    public List<Team> findTeams() {
        TypedQuery<Team> query = em.createNamedQuery("Team.findAll", Team.class);
        return query.getResultList();
    }
    
    public Team findTeamById(Long id) {
        return em.find(Team.class, id);
    }
    
    public Team createTeam(Team team)
    {
        em.persist(team);
        return team;
    }
    public void deleteTeam(int id)
    {
        Team team = em.find(Team.class, id);
        em.remove(em.merge(team));
    }
    public Team updateTeam(Team team)
    {
        return em.merge(team);
    }
    public Collection<Person> getTeamMember(Team team)
    {
        return findTeamById((long)team.getTeamID()).getPersonCollection();
        
    }
}
