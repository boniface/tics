/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.mentoring.tabs;

import zm.hashcode.tics.client.web.content.system.mentoring.tabs.*;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;

/**
 *
 * @author Ferox
 */
public final class MentoringSessionTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;

    public MentoringSessionTab(TicsMain app) {
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
