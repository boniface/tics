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
import zm.hashcode.tics.app.facade.training.course.CourseTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.institutions.InstitutionMenu;
import zm.hashcode.tics.client.web.content.training.course.forms.CourseTypeForm;
import zm.hashcode.tics.client.web.content.training.course.model.CourseTypeBean;
import zm.hashcode.tics.client.web.content.training.course.tables.CourseTypeTable;
import zm.hashcode.tics.client.web.content.training.course.util.CourseTypeUtil;
import zm.hashcode.tics.domain.training.course.CourseType;

/**
 *
 * @author geek
 */
public class CourseTypeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final CourseTypeForm form;
    private final CourseTypeTable table;

    public CourseTypeTab(TicsMain app) {
        main = app;
        form = new CourseTypeForm();
        table = new CourseTypeTable(main);
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
            final CourseType courseType = CourseTypeFacade.getCourseTypeService().find(table.getValue().toString());
            final CourseTypeBean bean = new CourseTypeUtil().getBean(courseType);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            CourseTypeFacade.getCourseTypeService().persist(getNewEntity(binder));
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
            CourseTypeFacade.getCourseTypeService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        CourseTypeFacade.getCourseTypeService().remove(getUpdateEntity(binder));
        getHome();
    }

    private CourseType getNewEntity(FieldGroup binder) {
        final CourseTypeBean bean = ((BeanItem<CourseTypeBean>) binder.getItemDataSource()).getBean();

        final CourseType courseType = new CourseType.Builder(bean.getName())
                .build();
        return courseType;
    }

    private CourseType getUpdateEntity(FieldGroup binder) {
        final CourseTypeBean bean = ((BeanItem<CourseTypeBean>) binder.getItemDataSource()).getBean();

        final CourseType courseType = new CourseType.Builder(bean.getName())
                .id(bean.getId())
                .build();
        return courseType;
    }

    private void getHome() {
        main.content.setSecondComponent(new InstitutionMenu(main, "COURSETYPE"));
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
