/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.job.JobClassificationFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.job.JobClassification;

/**
 *
 * @author geek
 */
public class JobClassificationTable extends Table {

    private final TicsMain main;

    public JobClassificationTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Current Title", String.class, null);
        addContainerProperty("Old Title", String.class, null);
        addContainerProperty("Old Code", String.class, null);
        addContainerProperty("Current Code", String.class, null);
        addContainerProperty("Code Conversion", String.class, null);
        addContainerProperty("Comment", String.class, null);
//        addContainerProperty("Job Classification", String.class, null);

        List<JobClassification> JobClassificationList = JobClassificationFacade.getJobClassificationService().findAll();
        for (JobClassification iJobClassification : JobClassificationList) {
            addItem(new Object[]{iJobClassification.getCurrentTitle(),
                iJobClassification.getOldTitle(),
                iJobClassification.getOldCode(),
                iJobClassification.getCurrentCode(),
                iJobClassification.getCodeConversion(),
                iJobClassification.getComment()
            }, iJobClassification.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }
}
