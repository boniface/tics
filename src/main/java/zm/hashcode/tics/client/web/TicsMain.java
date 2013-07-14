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
import java.util.List;
import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.domain.ui.demographics.Role;
import zm.hashcode.tics.repository.ui.demographics.RoleRepository;

/**
 *
 * @author boniface
 */
public class TicsMain extends UI {
   
    
    @Override
    protected void init(VaadinRequest request) {
        
         
        SpringContext helper = new SpringContext();
        RoleRepository repo = helper.getBean(RoleRepository.class);
        List<Role> role = repo.findAll();
        for (Role role1 : role) {
            System.out.println(" THE FIRST ROLE IS "+role1.getRolename());
        }
        VerticalLayout layout = new VerticalLayout();
        Button b = new Button("This is a Fraking Button"+ role.size());
        Label label = new Label("hello World ");
        layout.addComponent(label);
        layout.addComponent(b);
        setContent(layout);
    }
}
