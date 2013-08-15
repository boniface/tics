/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.sidebar;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.password.PasswordMenu;
import static zm.hashcode.tics.client.web.sidebar.PasswordTree.MANAGE_USERS;

/**
 *
 * @author Tiwana Siyabonga
 */
public class HomeTree extends Tree implements ItemClickEvent.ItemClickListener{
   private final TicsMain main;
    public static final Object MANAGE_USERS = "Change PASSWORD";
    private static final String LANDING_TAB = "LANDING";
    public HomeTree(TicsMain main) {
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
        main.content.setSecondComponent(new PasswordMenu(main, LANDING_TAB));

    }

}
