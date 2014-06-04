/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.controller;

import ch.brinika.sportsplanner5000.business.EventEJB;
import ch.brinika.sportsplanner5000.domain.Event;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author simon
 */
public class EventController {

    private Event event = new Event();
    private List<Event> eventList  = new ArrayList<Event>();
    
    @EJB
    private EventEJB eventEJB;

    /**
     *
     */
    public void doCreateEvent()
    {
        eventEJB.createEvent(event);
        eventList = eventEJB.findEvents();
       // return "Event_Created";
    }
    
    /**
     *
     */
    public void doUpdateEvent()
    {
        eventEJB.updateEvent(event);
        eventList = eventEJB.findEvents();
       // return "Event_updated";
    }
     
    /**
     *
     * @param id
     */
    public void doDeleteEvent(int id)
    {
        eventEJB.deleteEvent(id);
        eventList = eventEJB.findEvents();
        //return "Event_deleted";
    }
    
    /**
     *
     * @return
     */
    public Event getEvent() {
        return event;
    }

    /**
     *
     * @param event
     */
    public void setEvent(Event  event) {
        this.event = event;
    }

    /**
     *
     * @return
     */
    public List<Event> getEventList() {
        eventList = eventEJB.findEvents();
        return eventList;
    }

    /**
     *
     * @param eventList
     */
    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    /**
     *
     * @return
     */
    public EventEJB getEventEJB() {
        return eventEJB;
    }

    /**
     *
     * @param eventEJB
     */
    public void setEventEJB(EventEJB eventEJB) {
        this.eventEJB = eventEJB;
    }
    
}
