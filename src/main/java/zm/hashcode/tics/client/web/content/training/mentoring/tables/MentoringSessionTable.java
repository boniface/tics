/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.mentoring.tables;

import com.vaadin.ui.Table;
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringSessionFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.mentoring.MentoringSession;

/**
 *
 * @author geek
 */
public class MentoringSessionTable extends Table {

    private final TicsMain main;

    public MentoringSessionTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Session Name", String.class, null);
        addContainerProperty("Start Date", Date.class, null);
        addContainerProperty("End Date", Date.class, null);
        addContainerProperty("Mentoring Notes", String.class, null);

        List<MentoringSession> mentoringSessions = MentoringSessionFacade.getMentoringSessionService().findAll();
        for (MentoringSession mentoringSession : mentoringSessions) {
            addItem(new Object[]{mentoringSession.getSessionName(),
                mentoringSession.getStartDate(),
                mentoringSession.getEndDate(),
                mentoringSession.getMentoringNotes()
            }, mentoringSession.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
