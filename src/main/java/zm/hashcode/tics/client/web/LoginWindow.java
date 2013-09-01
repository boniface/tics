/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author boniface
 */
public class LoginWindow extends VerticalLayout {

    private Button btnLogin = new Button("Login");
    private TextField login = new TextField("E-Mail Address");
    private PasswordField password = new PasswordField("Password");
    private final VerticalLayout rootPanel = new VerticalLayout();
    private final HorizontalLayout sponsors = new HorizontalLayout();
    private final HorizontalLayout header = new HorizontalLayout();
    private final Panel panel = new Panel("Please login to use the System");
    private final FormLayout form = new FormLayout();
    private final TicsMain main;

    public LoginWindow(TicsMain app) {
        addStyleName("login");
        main = app;
        setCaption("login");
        initUI();
    }

    private void initUI() {


        rootPanel.setSizeFull();
        rootPanel.setMargin(true);


        panel.setWidth("400px");
        form.setMargin(true);
        form.addStyleName("login-layout");
        btnLogin.addStyleName("default");
        form.addComponent(login);
        form.addComponent(password);
        form.addComponent(btnLogin);
        panel.setContent(form);


        rootPanel.addComponent(header);
        rootPanel.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

        rootPanel.addComponent(panel);
        rootPanel.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

        rootPanel.addComponent(sponsors);
        rootPanel.setComponentAlignment(sponsors, Alignment.MIDDLE_CENTER);

        btnLogin.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                    main.authenticate((String) login.getValue(), (String) password.getValue());
//                    open(new ExternalResource(HashWorkMain.getInstance().getURL()));
                } catch (Exception e) {
                    Notification.show("Login failed", "Bad Username or Password", Notification.Type.ERROR_MESSAGE);
                }
            }
        });

        addComponent(rootPanel);

    }
}
