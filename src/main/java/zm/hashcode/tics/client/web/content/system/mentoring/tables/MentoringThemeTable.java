/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringThemeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.mentoring.MentoringTheme;

/**
 *
 * @author geek
 */
public class MentoringThemeTable extends Table {

    private final TicsMain main;

    public MentoringThemeTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Mentoring Theme;", String.class, null);

        List<MentoringTheme> mentoringThemes = MentoringThemeFacade.getMentoringThemeService().findAll();
        for (MentoringTheme mentoringTheme : mentoringThemes) {
            addItem(new Object[]{mentoringTheme.getMentoringTheme()
            }, mentoringTheme.getId());
        }
        //     Allow selecting items from the table.

        setNullSelectionAllowed(false);
        //
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
