/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package ch.brinika.sportsplanner5000.business;

import org.primefaces.component.tabview.TabView;

/**
 *
 * @author Simon
 */
public class TabBean {
    
    private TabView messagesTab = new TabView();
    
    public TabView getMessagesTab () {
        return messagesTab;
    }
    
    public void setMessagesTab(TabView messagesTab ) {
        this.messagesTab = messagesTab;
    }
    
    public void someDecisionMethod(int index){
        this.messagesTab.setActiveIndex(index);
    }
    
}
