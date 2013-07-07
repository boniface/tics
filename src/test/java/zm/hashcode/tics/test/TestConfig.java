/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import zm.hashcode.tics.app.conf.AppConfig;
import zm.hashcode.tics.app.conf.WebConfig;
import zm.hashcode.tics.app.init.Start;

/**
 *
 * @author boniface
 */
@Configuration
@ComponentScan(basePackages = "zm.hashcode.tics",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                value = {WebConfig.class, Start.class})})
@Import(AppConfig.class)
@ActiveProfiles("integration-test")
public class TestConfig {
    
}
