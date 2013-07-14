/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.conf;

import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author boniface
 */
public class SpringContext {
    
private ApplicationContext context;
    public SpringContext(ServletContext servletContext) {
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }
    public Object getBean(final String beanRef) {
        return context.getBean(beanRef);
    }    
}
