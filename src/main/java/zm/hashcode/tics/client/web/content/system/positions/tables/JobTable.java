/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.job.JobFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.job.Job;

/**
 *
 * @author geek
 */
public class JobTable extends Table {

    private final TicsMain main;

    public JobTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Job Title", String.class, null);
        addContainerProperty("Job Code", String.class, null);
        addContainerProperty("Job Description", String.class, null);
//        addContainerProperty("Job Classification", String.class, null);

        List<Job> joblist = JobFacade.getJobService().findAll();
        for (Job iJob : joblist) {
            addItem(new Object[]{iJob.getTitle(),
                iJob.getCode(),
                iJob.getDescription()
            }, iJob.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }
}
