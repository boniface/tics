/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.tabs;

import zm.hashcode.tics.client.web.content.users.tabs.*;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstitutionFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstructorsFacade;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.traininginstitution.TrainingInstitutionsMenu;
import zm.hashcode.tics.client.web.content.system.traininginstitution.forms.TrainingInstitutionForm;
import zm.hashcode.tics.client.web.content.system.traininginstitution.model.TrainingInstitutionBean;
import zm.hashcode.tics.client.web.content.system.traininginstitution.tables.TrainingInstitutionTable;
import zm.hashcode.tics.client.web.content.system.traininginstitution.util.TrainingInstitutionUtil;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author Ferox
 */
public final class MentoringStrentheningTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;

    public MentoringStrentheningTab(TicsMain app) {
        main = app;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();

    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
    }

    private void saveForm(FieldGroup binder) {
    }

    private void saveEditedForm(FieldGroup binder) {
    }

    private void deleteForm(FieldGroup binder) {
    }
}
