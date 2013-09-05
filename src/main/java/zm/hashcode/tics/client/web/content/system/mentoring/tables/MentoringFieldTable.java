/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringFieldFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.mentoring.MentoringField;

/**
 *
 * @author geek
 */
public class MentoringFieldTable extends Table {

    private final TicsMain main;

    public MentoringFieldTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Field Name", String.class, null);

        List<MentoringField> mentoringFields = MentoringFieldFacade.getMentoringFieldService().findAll();
        for (MentoringField mentoringField : mentoringFields) {
            addItem(new Object[]{mentoringField.getFieldName()
            }, mentoringField.getId());
        }
        //     Allow selecting items from the table.

        setNullSelectionAllowed(false);
        //
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
