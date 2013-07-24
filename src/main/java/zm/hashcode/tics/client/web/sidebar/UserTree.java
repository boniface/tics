/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.sidebar;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.users.UserMenu;

/**
 *
 * @author boniface
 */
public class UserTree extends Tree implements ItemClickEvent.ItemClickListener{
    private final TicsMain main;
    public static final Object MANAGE_USERS = "Aminister USERS";
    private static final String LANDING_TAB = "LANDING";
    public UserTree(TicsMain main) {
        this.main = main;
        addItem(MANAGE_USERS);

        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);
    }
    
    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (MANAGE_USERS.equals(itemId)) {
                manageUsersView();
            }
        }
    }
    private void manageUsersView() {
        main.content.setSecondComponent(new UserMenu(main, LANDING_TAB));

    }

}
