/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author boniface
 */
public class Menu extends VerticalLayout {

    private TicsMain main;
    private TabSheet tab;

    public Menu() {
    }
    
    public Menu(TicsMain app, String selectedTab) {
        main = app;
        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");
    }

    public TicsMain getMain() {
        return main;
    }

    public TabSheet getTab() {
        return tab;
    }
    
}