/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.conf;

import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author boniface
 */
@Configuration
@EnableCaching
@ComponentScan("zm.hashcode.tics.services")
public class CacheConfig {

    @Bean
    public SimpleCacheManager cacheManager() {

        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<>();
        caches.add(defaultBean().getObject());
        caches.add(persons().getObject());
        caches.add(facilities().getObject());
        caches.add(competencies().getObject());
        caches.add(courses().getObject());
        caches.add(locations().getObject());
         caches.add(titles().getObject());


        cacheManager.setCaches(caches);
        return cacheManager;
    }

    @Bean
    public ConcurrentMapCacheFactoryBean defaultBean() {
        ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
        cacheFactoryBean.setName("default");
        return cacheFactoryBean;

    }

    @Bean
    public ConcurrentMapCacheFactoryBean persons() {
        ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
        cacheFactoryBean.setName("persons");
        return cacheFactoryBean;
    }
    
        @Bean
    public ConcurrentMapCacheFactoryBean titles() {
        ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
        cacheFactoryBean.setName("titles");
        return cacheFactoryBean;
    }

    @Bean
    public ConcurrentMapCacheFactoryBean facilities() {
        ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
        cacheFactoryBean.setName("facilities");
        return cacheFactoryBean;
    }

    @Bean
    public ConcurrentMapCacheFactoryBean competencies() {
        ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
        cacheFactoryBean.setName("competencies");
        return cacheFactoryBean;
    }

    @Bean
    public ConcurrentMapCacheFactoryBean courses() {
        ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
        cacheFactoryBean.setName("courses");
        return cacheFactoryBean;
    }
    @Bean
    public ConcurrentMapCacheFactoryBean locations() {
        ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
        cacheFactoryBean.setName("locations");
        return cacheFactoryBean;
    }
}
