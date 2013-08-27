/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.tabs;

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
import zm.hashcode.tics.app.facade.training.course.CriteriaFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.institutions.InstitutionMenu;
import zm.hashcode.tics.client.web.content.training.course.forms.CriteriaForm;
import zm.hashcode.tics.client.web.content.training.course.model.CriteriaBean;
import zm.hashcode.tics.client.web.content.training.course.tables.CriteriaTable;
import zm.hashcode.tics.client.web.content.training.course.util.CriteriaUtil;
import zm.hashcode.tics.domain.training.course.Criteria;

/**
 *
 * @author geek
 */
public class CriteriaTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final CriteriaForm form;
    private final CriteriaTable table;

    public CriteriaTab(TicsMain app) {
        main = app;
        form = new CriteriaForm();
        table = new CriteriaTable(main);
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
            final Criteria criteria = CriteriaFacade.getCriteriaService().find(table.getValue().toString());
            final CriteriaBean bean = new CriteriaUtil().getBean(criteria);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            CriteriaFacade.getCriteriaService().persist(getNewEntity(binder));
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
            CriteriaFacade.getCriteriaService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        CriteriaFacade.getCriteriaService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Criteria getNewEntity(FieldGroup binder) {
        final CriteriaBean bean = ((BeanItem<CriteriaBean>) binder.getItemDataSource()).getBean();

        final Criteria criteria = new Criteria.Builder(bean.getName())
                .build();
        return criteria;
    }

    private Criteria getUpdateEntity(FieldGroup binder) {
        final CriteriaBean bean = ((BeanItem<CriteriaBean>) binder.getItemDataSource()).getBean();

        final Criteria criteria = new Criteria.Builder(bean.getName())
                .id(bean.getId())
                .build();
        return criteria;
    }

    private void getHome() {
        main.content.setSecondComponent(new InstitutionMenu(main, "COURSECRITERIA"));
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
