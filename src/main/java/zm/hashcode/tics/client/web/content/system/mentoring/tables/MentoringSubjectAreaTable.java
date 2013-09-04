/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringSubjectAreaFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.mentoring.MentoringSubjectArea;

/**
 *
 * @author geek
 */
public class MentoringSubjectAreaTable extends Table {

    private final TicsMain main;

    public MentoringSubjectAreaTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Subject Area;", String.class, null);

        List<MentoringSubjectArea> mentoringSubjectAreas = MentoringSubjectAreaFacade.getMentoringSubjectAreaService().findAll();
        for (MentoringSubjectArea mentoringSubjectArea : mentoringSubjectAreas) {
            addItem(new Object[]{mentoringSubjectArea.getSubjectArea()
            }, mentoringSubjectArea.getId());
        }
//     Allow selecting items from the table.

        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }
}
