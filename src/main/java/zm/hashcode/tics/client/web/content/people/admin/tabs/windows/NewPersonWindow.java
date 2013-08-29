/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.ui.demographics.GenderFacade;
import zm.hashcode.tics.app.facade.ui.demographics.IdentificationTypeFacade;
import zm.hashcode.tics.app.facade.ui.demographics.RaceFacade;
import zm.hashcode.tics.app.facade.ui.demographics.TitleFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.AdministerMenu;
import zm.hashcode.tics.client.web.content.people.admin.forms.NewPersonForm;
import zm.hashcode.tics.client.web.content.people.admin.model.PersonBean;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Demography;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.PersonIdentities;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;
import zm.hashcode.tics.domain.ui.demographics.Race;
import zm.hashcode.tics.domain.ui.demographics.Title;

/**
 *
 * @author Ferox
 */
public final class NewPersonWindow extends VerticalLayout implements
        Button.ClickListener {

    private final TicsMain main;
    public final NewPersonForm form;

    public NewPersonWindow(TicsMain app) {
        main = app;
        form = new NewPersonForm();
        setSizeFull();
        addComponent(form);
        addListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.save) {
            saveForm(form.binder);
        } else if (source == form.edit) {
            setEditFormProperties();
        } else if (source == form.cancel) {
            getHome();
        } else if (source == form.update) {
//            saveEditedForm(form.binder);
        } else if (source == form.delete) {
            deleteForm(form.binder);
        }
    }

    private void saveForm(FieldGroup binder) {
        System.out.println("SAVE EMTHOD ENTERED ");
        try {
            binder.commit();
            PersonFacade.getPersonService().persist(getNewEntity(binder));
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
//        PersonFacade.getPersonService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Person getNewEntity(FieldGroup binder) {
        final PersonBean bean = ((BeanItem<PersonBean>) binder.getItemDataSource()).getBean();
        final IdentificationType identificationType = IdentificationTypeFacade.getIdentificationTypeService().find(bean.getIdentitiesId());
        final Facility facility = FacilityFacade.getFacilityService().find(bean.getFacilityId());
        final Title title = TitleFacade.getTitleService().find(bean.getTitleId());
        final Gender gender = GenderFacade.getGenderService().find(bean.getGenderId());
        final Race race = RaceFacade.getRaceService().find(bean.getRaceId());
        final Demography demo = new Demography.Builder(gender).race(race).build();
        PersonIdentities personIdentities = new PersonIdentities.Builder(identificationType)
                .idValue(bean.getIdValue())
                .build();

        final List<PersonIdentities> ids = new ArrayList<>();
        ids.add(personIdentities);

        final Person person = new Person.Builder(bean.getFirstname(), bean.getSurname())
                .facility(facility)
                .identities(ids)
                .othername(bean.getOthername())
                .title(title)
                .demography(demo)
                .build();

        return person;
    }

    private void getHome() {
        main.content.setSecondComponent(new AdministerMenu(main, "LANDING"));
    }

    private void setEditFormProperties() {
        form.binder.setReadOnly(false);
        form.save.setVisible(false);
        form.edit.setVisible(false);
        form.cancel.setVisible(true);
        form.delete.setVisible(false);
        form.update.setVisible(true);
    }

    private void setReadFormProperties() {
        form.binder.setReadOnly(true);
        //Buttons Behaviou
        form.save.setVisible(false);
        form.edit.setVisible(true);
        form.cancel.setVisible(true);
        form.delete.setVisible(true);
        form.update.setVisible(false);
    }

    private void addListeners() {
        //Register Button Listeners
        form.save.addClickListener((ClickListener) this);
        form.edit.addClickListener((ClickListener) this);
        form.cancel.addClickListener((ClickListener) this);
        form.update.addClickListener((ClickListener) this);
        form.delete.addClickListener((ClickListener) this);

    }
}
