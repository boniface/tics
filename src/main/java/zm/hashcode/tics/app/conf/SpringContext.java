/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.conf;

import com.vaadin.server.VaadinServlet;
import java.io.Serializable;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author boniface
 */
public class SpringContext implements Serializable{
    private ApplicationContext context;
    public SpringContext() {
        ServletContext servletContext = VaadinServlet.getCurrent().getServletContext();
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }
    public <T extends Object> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
    
    public Object getStringBean(String bean) {
        return context.getBean(bean);
    }
}
