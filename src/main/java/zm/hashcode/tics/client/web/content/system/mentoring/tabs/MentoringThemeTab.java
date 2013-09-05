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
import zm.hashcode.tics.app.facade.training.mentoring.MentoringFieldFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringThemeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.mentoring.MentoringSetupMenu;
import zm.hashcode.tics.client.web.content.system.mentoring.forms.MentoringThemeForm;
import zm.hashcode.tics.client.web.content.system.mentoring.model.MentoringThemeBean;
import zm.hashcode.tics.client.web.content.system.mentoring.tables.MentoringThemeTable;
import zm.hashcode.tics.client.web.content.system.mentoring.util.MentoringThemeUtil;
import zm.hashcode.tics.domain.training.mentoring.MentoringField;
import zm.hashcode.tics.domain.training.mentoring.MentoringTheme;

/**
 *
 * @author Ferox
 */
public final class MentoringThemeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final MentoringThemeForm form;
    private final MentoringThemeTable table;
    //
    private String mentoringFieldId; // for and ENTITy

    public MentoringThemeTab(TicsMain app) {
        main = app;
        form = new MentoringThemeForm();
        table = new MentoringThemeTable(main);
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
            final MentoringTheme mentoringTheme = MentoringThemeFacade.getMentoringThemeService().find(table.getValue().toString());
            final MentoringThemeBean bean = new MentoringThemeUtil().getBean(mentoringTheme);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.mentoringFieldCombo) {
            mentoringFieldId = property.getValue().toString();
        }

    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            MentoringThemeFacade.getMentoringThemeService().persist(getNewEntity(binder));
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
            MentoringThemeFacade.getMentoringThemeService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        MentoringThemeFacade.getMentoringThemeService().remove(getUpdateEntity(binder));
        getHome();
    }

    private MentoringTheme getNewEntity(FieldGroup binder) {
        final MentoringThemeBean bean = ((BeanItem<MentoringThemeBean>) binder.getItemDataSource()).getBean();
        MentoringField mentoringField = MentoringFieldFacade.getMentoringFieldService().find(mentoringFieldId);
        final MentoringTheme mentoringTheme = new MentoringTheme.Builder(bean.getMentoringTheme())
                .mentoringField(mentoringField)
                .build();
        return mentoringTheme;
    }

    private MentoringTheme getUpdateEntity(FieldGroup binder) {
        final MentoringThemeBean bean = ((BeanItem<MentoringThemeBean>) binder.getItemDataSource()).getBean();
        MentoringField mentoringField = MentoringFieldFacade.getMentoringFieldService().find(mentoringFieldId);
        final MentoringTheme mentoringTheme = new MentoringTheme.Builder(bean.getMentoringTheme())
                .mentoringField(mentoringField)
                .id(bean.getId())
                .build();
        return mentoringTheme;
    }

    private void getHome() {
        main.content.setSecondComponent(new MentoringSetupMenu(main, "THEME"));
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
        form.mentoringFieldCombo.addValueChangeListener((ValueChangeListener) this);
    }
}
