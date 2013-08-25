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
import zm.hashcode.tics.app.facade.training.competencies.CompetencyTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.competencies.CompetenciesMenu;
import zm.hashcode.tics.client.web.content.system.competencies.forms.CompetencyTypeForm;
import zm.hashcode.tics.client.web.content.system.competencies.model.CompetencyTypeBean;
import zm.hashcode.tics.client.web.content.system.competencies.tables.CompetencyTypeTable;
import zm.hashcode.tics.client.web.content.system.competencies.util.CompetencyTypeUtil;
import zm.hashcode.tics.domain.training.competencies.CompetencyType;

/**
 *
 * @author geek
 */
public class CompetencyTypeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final CompetencyTypeForm form;
    private final CompetencyTypeTable table;
    private String locationId; // for an ENTITY

    public CompetencyTypeTab(TicsMain app) {
        main = app;
        form = new CompetencyTypeForm();
        table = new CompetencyTypeTable(main);
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
            final CompetencyType competencyType = CompetencyTypeFacade.getCompetencyTypeService().find(table.getValue().toString());
            final CompetencyTypeBean bean = new CompetencyTypeUtil().getBean(competencyType);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
//        else if (property == form.locationComboBox) {
//            locationId = property.getValue().toString();
//        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            CompetencyTypeFacade.getCompetencyTypeService().persist(getNewEntity(binder));
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
            CompetencyTypeFacade.getCompetencyTypeService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        CompetencyTypeFacade.getCompetencyTypeService().remove(getUpdateEntity(binder));
        getHome();
    }

    private CompetencyType getNewEntity(FieldGroup binder) {
        final CompetencyTypeBean bean = ((BeanItem<CompetencyTypeBean>) binder.getItemDataSource()).getBean();

        ////    private LocationAddress contact;
//      // blow out LocationAddress ATTRIBUTE below
//          private String postalAddress;
//          private String physicalAddress;
//          private String contactNumber;
//          private String postalCode;
//          private String emailAddress;

//        final LocationAddress locationAddress = new LocationAddress.Builder(bean.getContactNumber())
//                .emailAddress(bean.getEmailAddress())
//                .physicalAddress(bean.getPhysicalAddress())
//                .postalAddress(bean.getPostalAddress())
//                .postalCode(bean.getPostalCode())
//                .build();

        final CompetencyType competencyType = new CompetencyType.Builder(bean.getName())
                .build();
        return competencyType;
    }

    private CompetencyType getUpdateEntity(FieldGroup binder) {
        final CompetencyTypeBean bean = ((BeanItem<CompetencyTypeBean>) binder.getItemDataSource()).getBean();

        ////    private LocationAddress contact;
//      // blow out LocationAddress ATTRIBUTE below
//          private String postalAddress;
//          private String physicalAddress;
//          private String contactNumber;
//          private String postalCode;
//          private String emailAddress;

//        final LocationAddress locationAddress = new LocationAddress.Builder(bean.getContactNumber())
//                .emailAddress(bean.getEmailAddress())
//                .physicalAddress(bean.getPhysicalAddress())
//                .postalAddress(bean.getPostalAddress())
//                .postalCode(bean.getPostalCode())
//                .build();

        final CompetencyType competencyType = new CompetencyType.Builder(bean.getName())
                .id(bean.getId())
                .build();
        return competencyType;
    }

    private void getHome() {
        main.content.setSecondComponent(new CompetenciesMenu(main, "LANDING"));
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
//        form.locationComboBox.addValueChangeListener((ValueChangeListener) this);
    }
}
