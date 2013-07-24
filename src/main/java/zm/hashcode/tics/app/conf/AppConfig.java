/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

/**
 *
 * @author boniface
 */
@Configuration
@Import(RepositoryConfig.class)
public class AppConfig {

    @Autowired
    private Environment environment;
}
