/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package ch.brinika.sportsplanner5000.business;

import org.primefaces.component.tabview.TabView;

/**
 *
 * @author Simon Kaufmann
 * @author Andreas Briw
 * @author Michael Niggeler
 */
public class TabEJB {
    
    private TabView messagesTab = new TabView();
    
    /**
     *
     * @return
     */
    public TabView getMessagesTab () {
        return messagesTab;
    }
    
    /**
     *
     * @param messagesTab
     */
    public void setMessagesTab(TabView messagesTab ) {
        this.messagesTab = messagesTab;
    }
    
    /**
     * Setzt den Index des Tabs
     * @param index
     */
    public void someDecisionMethod(int index){
        this.messagesTab.setActiveIndex(index);
    }
    
}
