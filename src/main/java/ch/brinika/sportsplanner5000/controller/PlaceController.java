/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.brinika.sportsplanner5000.controller;

import ch.brinika.sportsplanner5000.business.PlaceEJB;
import ch.brinika.sportsplanner5000.domain.Person;
import ch.brinika.sportsplanner5000.domain.Place;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.component.api.UIColumn;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author Simon Kaufmann
 * @author Andreas Briw
 * @author Michael Niggeler
 */
public class PlaceController {
    
    private Place place = new Place();
    private List<Place> placeList  = new ArrayList<Place>();
    
    @EJB
    private PlaceEJB placeEJB;

    /**
     * Erstellt ein Ort und füllt die Ortsliste.
     */
    public void doCreatePlace()
    {
        placeEJB.createPlace(place);
        placeList = placeEJB.findPlaces();
        //return "Place_created";
    }
    
    /**
     * Aktualisiert den Ort und füllt die Ortsliste.
     */
    public void doUpdatePlace()
    {
        placeEJB.updatePlace(place);
        placeList = placeEJB.findPlaces();
        //return "Place_updated";
    }
    
    /**
     * Löscht das Team mit der übergebenen ID.
     * @param id
     */
    public void doDeletePlace(int id)
    {
        placeEJB.deletePlace(id);
        placeList = placeEJB.findPlaces();
        //return "Place_updated";
    }
    
    /**
     * Bei Zelleneditierung von einem Ort wird diese Methode ausgeführt
     * und die Werte ausgelesen.
     * Der editierte Ort wird dann in der Datenbank aktualisiert und die Ortsliste gefüllt.
     * @param event
     */
    public void onCellEdit(CellEditEvent event) {
        Object newValue = event.getNewValue();
        String newValueFromEdit = newValue.toString();
        
        UIColumn column =  event.getColumn();
        String columnHeader = column.getHeaderText();
        
        FacesContext context = FacesContext.getCurrentInstance();
        Place placeOld = context.getApplication().evaluateExpressionGet(context, "#{item}", Place.class);
        
        if("Ort".equals(columnHeader)){
            placeOld.setLocation(newValueFromEdit);
        }
        else if("Name".equals(columnHeader)){
            placeOld.setName(newValueFromEdit);
        }
        else if("Beschreibung".equals(columnHeader)){
            placeOld.setDescription(newValueFromEdit);
        }
        
        placeEJB.updatePlace(placeOld);
        placeList = placeEJB.findPlaces();
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
