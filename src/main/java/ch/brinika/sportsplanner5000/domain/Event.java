/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Simon Kaufmann
 * @author Andreas Briw
 * @author Michael Niggeler
 */
@Entity
@Table(name = "Event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventID", query = "SELECT e FROM Event e WHERE e.eventID = :eventID"),
    @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Event e WHERE e.name = :name"),
    @NamedQuery(name = "Event.findByType", query = "SELECT e FROM Event e WHERE e.type = :type")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "eventID")
    @GeneratedValue
    private Integer eventID;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Column(name = "sdate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sdate;

    /**
     *
     * @param sdate
     */
    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    /**
     *
     * @return
     */
    public Date getSdate() {
        return sdate;
    }
    //@JoinTable(name = "Team_has_Event", joinColumns = {
    //    @JoinColumn(name = "Event_eventID", referencedColumnName = "eventID")}, inverseJoinColumns = {
    //    @JoinColumn(name = "Team_teamID", referencedColumnName = "teamID")})
    //@ManyToMany
    //private Collection<Team> teamCollection;
    @JoinColumn(name = "Team_ID", referencedColumnName = "teamID")
    @ManyToOne(optional = false)
    private Team teamFromEvent;
    @JoinColumn(name = "Person_ID", referencedColumnName = "personID")
    @ManyToOne(optional = false)
    private Person personFromEvent;
    @JoinColumn(name = "Place_ID", referencedColumnName = "placeID")
    @ManyToOne(optional = false)
    private Place placeFromEvent;

    /**
     * Leerer Konstruktor
     */
    public Event() {
    }

    /**
     *
     * @param eventID
     */
    public Event(Integer eventID) {
        this.eventID = eventID;
    }

    /**
     *
     * @return
     */
    public Integer getEventID() {
        return eventID;
    }
    
    /**
     *
     * @param eventID
     */
    public void setEventID(Integer eventID) {
        this.eventID = eventID;
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

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
/*
    @XmlTransient
    public Collection<Team> getTeamCollection() {
        return teamCollection;
    }

    public void setTeamCollection(Collection<Team> teamCollection) {
        this.teamCollection = teamCollection;
    }
*/

    /**
     *
     * @return
     */
    
    public Person getPersonFromEvent() {
        return personFromEvent;
    }

    /**
     *
     * @param personFromEvent
     */
    public void setPersonFromEvent(Person personFromEvent) {
        this.personFromEvent = personFromEvent;
    }
    
    /**
     *
     * @return
     */
    public Team getTeamFromEvent() {
        return teamFromEvent;
    }

    /**
     *
     * @param teamFromEvent
     */
    public void setTeamFromEvent(Team teamFromEvent) {
        this.teamFromEvent = teamFromEvent;
    }
    
    /**
     *
     * @return
     */
    public Place getPlaceFromEvent() {
        return placeFromEvent;
    }

    /**
     *
     * @param placeFromEvent
     */
    public void setPlaceFromEvent(Place placeFromEvent) {
        this.placeFromEvent = placeFromEvent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventID != null ? eventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventID == null && other.eventID != null) || (this.eventID != null && !this.eventID.equals(other.eventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.brinika.sportsplanner5000.domain.Event[ eventID=" + eventID + " ]";
    }
    
}
