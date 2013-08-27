/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tables;

import zm.hashcode.tics.client.web.content.users.tables.*;
import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author boniface
 */
public class ManagePeopleTable extends Table {

    private final TicsMain main;

    public ManagePeopleTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Email", String.class, null);
        addContainerProperty("First Name", String.class, null);
        addContainerProperty("Last Name", String.class, null);
        addContainerProperty("Enabled", Boolean.class, null);


        List<User> personlist = UserFacade.getUserService().findAll();
        for (User user : personlist) {
            addItem(new Object[]{user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.isEnabled()
            }, user.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
