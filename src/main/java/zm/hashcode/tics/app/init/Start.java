/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.init;

import com.vaadin.server.VaadinServlet;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import zm.hashcode.tics.app.conf.AppConfig;
import zm.hashcode.tics.app.conf.WebConfig;

/**
 *
 * @author boniface
 */
@Profile("container")
public class Start implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();


// Register Spring security filter
        FilterRegistration.Dynamic springSecurityFilterChain =
                sc.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");


        sc.addListener(new ContextLoaderListener(rootContext));
        rootContext.register(AppConfig.class);

        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);
        dispatcherContext.scan("zm.hashcode.tics");

        // Context loader listener
        ServletRegistration.Dynamic dispatcher = sc.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        dispatcher.setInitParameter("spring.profiles.active", "container");

        ServletRegistration.Dynamic vaadin = sc.addServlet("gwt", VaadinServlet.class);
        vaadin.setLoadOnStartup(1);
        vaadin.addMapping("/app/*");
        vaadin.addMapping("/VAADIN/*");
        vaadin.setInitParameter("UI", "zm.hashcode.tics.client.web.TicsMain");
        vaadin.setInitParameter("widgetset", "zm.hashcode.tics.app.init.widgetset.widgets");





    }
}