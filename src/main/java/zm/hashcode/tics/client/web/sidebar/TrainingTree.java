/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.sidebar;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.TrainingMenu;
import zm.hashcode.tics.client.web.content.users.UserMenu;

/**
 *
 * @author boniface
 */
public class TrainingTree extends Tree implements ItemClickEvent.ItemClickListener{
    private final TicsMain main;
    public static final Object INSTITUTION = "Training INSTITUTION";
    private static final String LANDING_TAB = "LANDING";
    public TrainingTree(TicsMain main) {
        this.main = main;
        addItem(INSTITUTION);

        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);
    }
    
    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (INSTITUTION.equals(itemId)) {
                manageUsersView();
            }
        }
    }
    private void manageUsersView() {
        main.content.setSecondComponent(new TrainingMenu(main, LANDING_TAB));

    }

}
