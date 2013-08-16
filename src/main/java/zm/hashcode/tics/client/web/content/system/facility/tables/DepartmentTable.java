/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.DepartmentFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.offices.Department;

/**
 *
 * @author geek
 */
public class DepartmentTable extends Table {

    private final TicsMain main;

    public DepartmentTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Department Name", String.class, null);
        List<Department> departments = DepartmentFacade.getDepartmentService().findAll();
        for (Department iDepartment : departments) {
            addItem(new Object[]{iDepartment.getName()
            }, iDepartment.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
