/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.sidebar;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import zm.hashcode.tics.client.web.TicsMain;

/**
 *
 * @author Tiwana Siyabonga
 */
public class HomeTree extends Tree implements ItemClickEvent.ItemClickListener{
    
    private final TicsMain main;

    public HomeTree (TicsMain main) {
        this.main = main;
    }
    @Override
    public void itemClick(ItemClickEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
