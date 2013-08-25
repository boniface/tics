/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.competencies.tabs;

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
import zm.hashcode.tics.app.facade.training.competencies.CompetencyFacade;
import zm.hashcode.tics.app.facade.training.competencies.CompetencyTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.competencies.CompetenciesMenu;
import zm.hashcode.tics.client.web.content.system.competencies.forms.CompetencyForm;
import zm.hashcode.tics.client.web.content.system.competencies.model.CompetencyBean;
import zm.hashcode.tics.client.web.content.system.competencies.tables.CompetencyTable;
import zm.hashcode.tics.client.web.content.system.competencies.util.CompetencyUtil;
import zm.hashcode.tics.domain.training.competencies.Competency;
import zm.hashcode.tics.domain.training.competencies.CompetencyType;

/**
 *
 * @author geek
 */
public class CompetencyTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final CompetencyForm form;
    private final CompetencyTable table;
    private String competencyTypeId; // for an ENTITY

    public CompetencyTab(TicsMain app) {
        main = app;
        form = new CompetencyForm();
        table = new CompetencyTable(main);
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
            final Competency competency = CompetencyFacade.getCompetencyService().find(table.getValue().toString());
            final CompetencyBean bean = new CompetencyUtil().getBean(competency);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.competencyTypeIdCombo) {
            competencyTypeId = property.getValue().toString();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            CompetencyFacade.getCompetencyService().persist(getNewEntity(binder));
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
            CompetencyFacade.getCompetencyService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        CompetencyFacade.getCompetencyService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Competency getNewEntity(FieldGroup binder) {
        final CompetencyBean bean = ((BeanItem<CompetencyBean>) binder.getItemDataSource()).getBean();

        final CompetencyType competencyType = CompetencyTypeFacade.getCompetencyTypeService().find(competencyTypeId);

        final Competency competency = new Competency.Builder(bean.getName())
                .notes(bean.getNotes())
                .type(competencyType)
                .build();
        return competency;
    }

    private Competency getUpdateEntity(FieldGroup binder) {
        final CompetencyBean bean = ((BeanItem<CompetencyBean>) binder.getItemDataSource()).getBean();

        final CompetencyType competencyType = CompetencyTypeFacade.getCompetencyTypeService().find(competencyTypeId);

        final Competency competency = new Competency.Builder(bean.getName())
                .notes(bean.getNotes())
                .type(competencyType)
                .id(bean.getId())
                .build();
        return competency;
    }

    private void getHome() {
        main.content.setSecondComponent(new CompetenciesMenu(main, "COMPETENCY"));
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
        form.competencyTypeIdCombo.addValueChangeListener((ValueChangeListener) this);
    }
}
