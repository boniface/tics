/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author boniface
 */
public class TicsMain extends UI {
    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        Button b = new Button("This is a Fraking Button");
        Label label = new Label("hello World ");
        layout.addComponent(label);
        layout.addComponent(b);
        setContent(layout);
    }
}
