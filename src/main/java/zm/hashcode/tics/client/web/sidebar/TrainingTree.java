/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.sidebar;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.course.CourseMenu;
import zm.hashcode.tics.client.web.content.training.institutions.InstitutionMenu;
import zm.hashcode.tics.client.web.content.training.mentoring.MentoringMenu;
import zm.hashcode.tics.client.web.content.training.nimart.NimartMenu;

/**
 *
 * @author boniface
 */
public class TrainingTree extends Tree implements ItemClickEvent.ItemClickListener {

    private final TicsMain main;
    public static final Object INSTITUTION = "Manage INSTITUTION";
    public static final Object COURSES = "Manage COURSES";
    public static final Object MENTORING = "Manage MENTORING";
    public static final Object NIMART = "Manage NIMAART";
    private static final String LANDING_TAB = "LANDING";

    public TrainingTree(TicsMain main) {
        this.main = main;
        addItem(INSTITUTION);
        addItem(COURSES);
        addItem(MENTORING);
//        addItem(NIMART);

        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);
    }

    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (INSTITUTION.equals(itemId)) {
                institutionView();
            } else if (COURSES.equals(itemId)) {
                coursesView();
            } else if (MENTORING.equals(itemId)) {
                mentoringView();
            } else if (NIMART.equals(itemId)) {
                nimartView();
            }
        }
    }

    private void institutionView() {
        main.content.setSecondComponent(new InstitutionMenu(main, LANDING_TAB));
    }

    private void coursesView() {
        main.content.setSecondComponent(new CourseMenu(main, LANDING_TAB));
    }

    private void mentoringView() {
        main.content.setSecondComponent(new MentoringMenu(main, LANDING_TAB));
    }

    private void nimartView() {
        main.content.setSecondComponent(new NimartMenu(main, LANDING_TAB));
    }
}
