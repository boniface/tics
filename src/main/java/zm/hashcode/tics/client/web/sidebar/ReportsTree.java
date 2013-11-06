/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.sidebar;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.reports.ReportsMenu;

/**
 *
 * @author boniface
 */
public class ReportsTree extends Tree implements ItemClickEvent.ItemClickListener {

    private final TicsMain main;
    public static final Object MANAGE_USERS = "Training REPORTS";
    private static final String LANDING_TAB = "LANDING";

    public ReportsTree(TicsMain main) {
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
        main.content.setSecondComponent(new ReportsMenu(main, LANDING_TAB));

    }
}
