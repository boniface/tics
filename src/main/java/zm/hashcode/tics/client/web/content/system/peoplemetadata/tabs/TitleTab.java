/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.tabs;

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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import zm.hashcode.tics.app.facade.ui.demographics.TitleFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.PeopleMetaDataMenu;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.forms.TitleForm;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.TitleBean;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tables.TitleTable;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.util.TitleUtil;
import zm.hashcode.tics.domain.ui.demographics.Title;

/**
 *
 * @author Ferox
 */
public final class TitleTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final TitleForm form;
    private final TitleTable table;

    public TitleTab(TicsMain app) {
        main = app;
        form = new TitleForm();
        table = new TitleTable(main);
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
            final Title title = TitleFacade.getTitleService().find(table.getValue().toString());
            final TitleBean bean = new TitleUtil().getBean(title);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            TitleFacade.getTitleService().persist(getNewEntity(binder));
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
            TitleFacade.getTitleService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        TitleFacade.getTitleService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Title getNewEntity(FieldGroup binder) {
        final TitleBean bean = ((BeanItem<TitleBean>) binder.getItemDataSource()).getBean();
        final Title title = new Title.Builder(bean.getTitle())
                .build();
        return title;
    }

    private Title getUpdateEntity(FieldGroup binder) {
        final TitleBean bean = ((BeanItem<TitleBean>) binder.getItemDataSource()).getBean();
        final Title title = new Title.Builder(bean.getTitle())
                .id(bean.getId())
                .build();
        return title;
    }

    private void getHome() {
        main.content.setSecondComponent(new PeopleMetaDataMenu(main, "TITLE"));
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
    }
}
