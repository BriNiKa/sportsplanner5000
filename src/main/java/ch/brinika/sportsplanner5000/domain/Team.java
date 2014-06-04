/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simon
 */
@Entity
@Table(name = "Team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
    @NamedQuery(name = "Team.findByTeamID", query = "SELECT t FROM Team t WHERE t.teamID = :teamID"),
    @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name")})
public class Team implements Serializable {
    @ManyToMany(mappedBy = "teamCollection")
    private Collection<Person> personCollection;
    @OneToMany(mappedBy = "teamFromEvent")
    private Collection<Event> eventCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "teamID")
    @GeneratedValue
    private Integer teamID;
    @Size(max = 45)
    @Column(name = "name")
    private String name;

    /**
     *
     */
    public Team() {
    }

    /**
     *
     * @param teamID
     */
    public Team(Integer teamID) {
        this.teamID = teamID;
    }

    /**
     *
     * @return
     */
    public Integer getTeamID() {
        return teamID;
    }

    /**
     *
     * @param teamID
     */
    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamID != null ? teamID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.teamID == null && other.teamID != null) || (this.teamID != null && !this.teamID.equals(other.teamID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.brinika.sportsplanner5000.domain.Team[ teamID=" + teamID + " ]";
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    /**
     *
     * @param personCollection
     */
    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    /**
     *
     * @param eventCollection
     */
    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }
    
}
