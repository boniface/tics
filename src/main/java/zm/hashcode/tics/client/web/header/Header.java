/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.header;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import java.awt.FlowLayout;
import zm.hashcode.tics.app.security.GetUserCredentials;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author boniface
 */
public class Header extends HorizontalLayout implements Button.ClickListener {

    private final Button button = new Button("Logout");
    private final FlowLayout flow = new FlowLayout();
    private Embedded logo = new Embedded("", new ThemeResource("img/rtclogo.png"));

    public Header() {
        setHeight("100px");
        setWidth("100%");
        setSpacing(true);
        addStyleName("sidebar");

        User user = new GetUserCredentials().getLoggedInUser();
        setHeight(90, Unit.PIXELS);
        setWidth(100, Unit.PERCENTAGE);
        addComponent(logo);
        setComponentAlignment(logo, Alignment.TOP_LEFT);
        addComponent(new Label(" Welcome " + user.getFirstname() + " " + user.getLastname()));
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_RIGHT);
        button.addStyleName("default");

        button.addClickListener(this);



    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        getUI().getPage().setLocation("/tics/app/");
        getSession().close();
    }
}
