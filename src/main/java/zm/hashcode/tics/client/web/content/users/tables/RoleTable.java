/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.users.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.demographics.Role;

/**
 *
 * @author boniface
 */
public final class RoleTable extends Table {

    private final TicsMain main;

    public RoleTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Role Name", String.class, null);
        addContainerProperty("Description", String.class, null);
        List<Role> roles = UserFacade.getRoleService().findAll();
        for (Role role : roles) {
            addItem(new Object[]{role.getRolename(),
                                 role.getDescription()
                                }, role.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
