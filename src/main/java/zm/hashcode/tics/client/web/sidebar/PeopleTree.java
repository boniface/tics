/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.sidebar;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.AdministerMenu;
import zm.hashcode.tics.client.web.content.people.person.PersonMenu;

/**
 *
 * @author boniface
 */
public class PeopleTree extends Tree implements ItemClickEvent.ItemClickListener {

    private final TicsMain main;
    public static final Object MANAGE_ADMIN = "Manage PEOPLE";
    public static final Object MANAGE_SELF = "Manage SELF";
    private static final String LANDING_TAB = "LANDING";

    public PeopleTree(TicsMain main) {
        this.main = main;
        addItem(MANAGE_ADMIN);
        addItem(MANAGE_SELF);

        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);
    }

    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (MANAGE_ADMIN.equals(itemId)) {
                administerPeople();
            } else if (MANAGE_ADMIN.equals(itemId)) {
                manageSelfView();
            }
        }
    }

    private void administerPeople() {
        main.content.setSecondComponent(new AdministerMenu(main, LANDING_TAB));
    }

    private void manageSelfView() {
        main.content.setSecondComponent(new PersonMenu(main, LANDING_TAB));
    }
}
