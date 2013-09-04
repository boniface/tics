/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.tabs;

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
import zm.hashcode.tics.app.facade.training.mentoring.MentoringObjectiveFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.mentoring.MentoringSetupMenu;
import zm.hashcode.tics.client.web.content.system.mentoring.forms.MentoringObjectiveForm;
import zm.hashcode.tics.client.web.content.system.mentoring.model.MentoringObjectiveBean;
import zm.hashcode.tics.client.web.content.system.mentoring.tables.MentoringObjectiveTable;
import zm.hashcode.tics.client.web.content.system.mentoring.util.MentoringObjectiveUtil;
import zm.hashcode.tics.domain.training.mentoring.MentoringObjective;

/**
 *
 * @author Ferox
 */
public final class MentoringObjectiveTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final MentoringObjectiveForm form;
    private final MentoringObjectiveTable table;

    public MentoringObjectiveTab(TicsMain app) {
        main = app;
        form = new MentoringObjectiveForm();
        table = new MentoringObjectiveTable(main);
        setSizeFull();
        addComponent(form);
        addComponent(table);
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
            saveEditedForm(form.binder);
        } else if (source == form.delete) {
            deleteForm(form.binder);
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            final MentoringObjective mentoringObjective = MentoringObjectiveFacade.getMentoringObjectiveService().find(table.getValue().toString());
            final MentoringObjectiveBean bean = new MentoringObjectiveUtil().getBean(mentoringObjective);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            MentoringObjectiveFacade.getMentoringObjectiveService().persist(getNewEntity(binder));
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveEditedForm(FieldGroup binder) {
        try {
            binder.commit();
            MentoringObjectiveFacade.getMentoringObjectiveService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        MentoringObjectiveFacade.getMentoringObjectiveService().remove(getUpdateEntity(binder));
        getHome();
    }

    private MentoringObjective getNewEntity(FieldGroup binder) {
        final MentoringObjectiveBean bean = ((BeanItem<MentoringObjectiveBean>) binder.getItemDataSource()).getBean();
        final MentoringObjective mentoringObjective = new MentoringObjective.Builder(bean.getMentoringObjective())
                .build();
        return mentoringObjective;
    }

    private MentoringObjective getUpdateEntity(FieldGroup binder) {
        final MentoringObjectiveBean bean = ((BeanItem<MentoringObjectiveBean>) binder.getItemDataSource()).getBean();
        final MentoringObjective mentoringObjective = new MentoringObjective.Builder(bean.getMentoringObjective())
                .id(bean.getId())
                .build();
        return mentoringObjective;
    }

    private void getHome() {
        main.content.setSecondComponent(new MentoringSetupMenu(main, "OBJECTIVE"));
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
        //Register Table Listerners
        table.addValueChangeListener((ValueChangeListener) this);
        //

    }
}
