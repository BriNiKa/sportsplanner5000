/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.controller;

import ch.brinika.sportsplanner5000.business.PlaceEJB;
import ch.brinika.sportsplanner5000.domain.Place;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author simon
 */
public class PlaceController {
    
    private Place place = new Place();
    private List<Place> placeList  = new ArrayList<Place>();
    
    @EJB
    private PlaceEJB placeEJB;

    /**
     *
     */
    public void doCreatePlace()
    {
        placeEJB.createPlace(place);
        placeList = placeEJB.findPlaces();
        //return "Place_created";
    }
    
    /**
     *
     */
    public void doUpdatePlace()
    {
        placeEJB.updatePlace(place);
        placeList = placeEJB.findPlaces();
        //return "Place_updated";
    }
     
    /**
     *
     * @param id
     */
    public void doDeletePlace(int id)
    {
        placeEJB.deletePlace(id);
        placeList = placeEJB.findPlaces();
        //return "Place_updated";
    }
    
    /**
     *
     * @return
     */
    public Place getPlace() {
        return place;
    }

    /**
     *
     * @param place
     */
    public void setPlace(Place  place) {
        this.place = place;
    }

    /**
     *
     * @return
     */
    public List<Place> getPlaceList() {
        placeList = placeEJB.findPlaces();
        return placeList;
    }

    /**
     *
     * @param placeList
     */
    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    /**
     *
     * @return
     */
    public PlaceEJB getPlaceEJB() {
        return placeEJB;
    }

    /**
     *
     * @param placeEJB
     */
    public void setPlaceEJB(PlaceEJB placeEJB) {
        this.placeEJB = placeEJB;
    }

    
    
}
