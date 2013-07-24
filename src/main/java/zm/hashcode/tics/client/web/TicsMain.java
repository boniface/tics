/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.client.web.footer.Footer;
import zm.hashcode.tics.client.web.header.Header;
import zm.hashcode.tics.client.web.sidebar.Sidebar;

/**
 *
 * @author boniface
 */
@PreserveOnRefresh
public class TicsMain extends UI {
 public final HorizontalSplitPanel content = new HorizontalSplitPanel();
    public final Footer footer = new Footer();
    private static ThreadLocal<TicsMain> threadLocal = new ThreadLocal<>();
    private AuthenticationManager authenticationManager;
    private SpringContext ctx;
    private Authentication auth;

    @Override
    protected void init(VaadinRequest request) {
        setInstance(this);
        setContent(new LoginWindow(this));
//        loadProtectedResources();
    }

    public static TicsMain getInstance() {
        return threadLocal.get();
    }

    // Set the current application instance 	
    public static void setInstance(TicsMain application) {
        if (getInstance() == null) {
            threadLocal.set(application);
        }
    }

    public Authentication authenticate(String login, String password) throws Exception {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password);
        ctx = new SpringContext();
        authenticationManager = (AuthenticationManager)ctx.getStringBean("authenticationManager");        
        setAuth(authenticationManager.authenticate(token));
        if (getAuth() != null) {
            SecurityContextHolder.getContext().setAuthentication(getAuth());
            TicsMain.setInstance(this);
            loadProtectedResources();
            return getAuth();
        }
        throw new Exception("failed to Login");
    }

    public Authentication getAuth() {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(Authentication auth) {
        this.auth = auth;
    }

    private void loadProtectedResources() {
        final Header header = new Header();
        content.setMaxSplitPosition(20, Unit.PERCENTAGE);
        content.setLocked(true);
        content.setFirstComponent(new Sidebar(this));
        content.setSecondComponent(new Button("This is a Button"));
        final VerticalLayout root = new VerticalLayout();
        root.addComponent(header);
        root.addComponent(content);
        root.addComponent(footer);
        setContent(root);
    }
}