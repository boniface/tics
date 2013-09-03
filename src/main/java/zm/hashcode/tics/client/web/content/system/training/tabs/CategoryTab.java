/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.training.tabs;

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
import zm.hashcode.tics.app.facade.training.course.CategoryFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.course.CourseMenu;
import zm.hashcode.tics.client.web.content.system.training.forms.CategoryForm;
import zm.hashcode.tics.client.web.content.system.training.model.CategoryBean;
import zm.hashcode.tics.client.web.content.system.training.tables.CategoryTable;
import zm.hashcode.tics.client.web.content.training.course.util.CategoryUtil;
import zm.hashcode.tics.domain.training.course.Category;

/**
 *
 * @author geek
 */
public class CategoryTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final CategoryForm form;
    private final CategoryTable table;

    public CategoryTab(TicsMain app) {
        main = app;
        form = new CategoryForm();
        table = new CategoryTable(main);
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
            final Category category = CategoryFacade.getCategoryService().find(table.getValue().toString());
            final CategoryBean bean = new CategoryUtil().getBean(category);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            CategoryFacade.getCategoryService().persist(getNewEntity(binder));
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
            CategoryFacade.getCategoryService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        CategoryFacade.getCategoryService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Category getNewEntity(FieldGroup binder) {
        final CategoryBean bean = ((BeanItem<CategoryBean>) binder.getItemDataSource()).getBean();

        final Category category = new Category.Builder(bean.getName())
                .build();
        return category;
    }

    private Category getUpdateEntity(FieldGroup binder) {
        final CategoryBean bean = ((BeanItem<CategoryBean>) binder.getItemDataSource()).getBean();

        final Category category = new Category.Builder(bean.getName())
                .id(bean.getId())
                .build();
        return category;
    }

    private void getHome() {
        main.content.setSecondComponent(new CourseMenu(main, "COURSECATEGORY"));
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
