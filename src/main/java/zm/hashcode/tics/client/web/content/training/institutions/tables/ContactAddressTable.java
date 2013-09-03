/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.institutions.util.TrainingInstructorUtil;
import zm.hashcode.tics.domain.training.institutions.InstitutionAddress;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;

/**
 *
 * @author geek
 */
public class ContactAddressTable extends Table {

    private final TicsMain main;

    public ContactAddressTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Email Address", String.class, null);
        addContainerProperty("Contact Number", String.class, null);
        addContainerProperty("Physical Address", String.class, null);
        addContainerProperty("Postal Address", String.class, null);
        addContainerProperty("Postal Code", String.class, null);
        addContainerProperty("City", String.class, null);

        TrainingInstitution trainingInstitution = TrainingInstructorUtil.getTrainingInstitution();
        List<InstitutionAddress> addresses = trainingInstitution.getInstitutionAddresses();
        int i = 1;
        for (InstitutionAddress address : addresses) {
            i++;
            addItem(new Object[]{
                address.getAddress().getEmailAddress(),
                address.getAddress().getContactNumber(),
                address.getAddress().getPhysicalAddress(),
                address.getAddress().getPostalAddress(),
                address.getAddress().getPostalCode(),
                address.getCity().getName()
            }, i);
        }

        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
