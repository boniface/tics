/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.tables;

import com.vaadin.ui.Table;
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.RegistrationBodyFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.people.RegistrationBody;

/**
 *
 * @author geek
 */
public class RegistrationBodyTable extends Table {

    private final TicsMain main;

    public RegistrationBodyTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Name", String.class, null);
        addContainerProperty("Description", String.class, null);
        addContainerProperty("Core Activity", String.class, null);
        addContainerProperty("Active", String.class, null);
        addContainerProperty("Start Date", Date.class, null);


        List<RegistrationBody> registrationBody = RegistrationBodyFacade.getRegistrationBodyService().findAll();
        for (RegistrationBody iRegistrationBody : registrationBody) {
            addItem(new Object[]{iRegistrationBody.getName(),
                iRegistrationBody.getDescription(),
                iRegistrationBody.getCoreActivity(),
                iRegistrationBody.getActive(),
                iRegistrationBody.getStartDate()
            }, iRegistrationBody.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
