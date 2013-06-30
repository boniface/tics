/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.util.sec;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Notification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import zm.hashcode.hashwork.client.web.LoginWindow;

/**
 *
 * @author boniface
 */
public class ViewChangeSecurityChecker implements ViewChangeListener{

    @Override
    public boolean beforeViewChange(ViewChangeEvent event) {
        if (event.getNewView() instanceof LoginWindow) {

            return true;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication == null ? false : authentication.isAuthenticated();   }

    @Override
    public void afterViewChange(ViewChangeEvent event) {
           Notification.show(" Can This Work Please ");
    }
}
