/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.header;

import com.vaadin.ui.Button;
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

    public Header() {


        User user = new GetUserCredentials().getLoggedInUser();
        setHeight(90, Unit.PIXELS);
        setWidth(100, Unit.PERCENTAGE);
        addComponent(new Label(" Welcome " + user.getFirstname()+ " " + user.getLastname()));
        addComponent(button);

        button.addClickListener(this);

    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        getUI().getPage().setLocation("/tics/app/");
        getSession().close();
    }
}
