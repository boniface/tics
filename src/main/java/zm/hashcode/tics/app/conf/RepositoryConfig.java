/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.conf;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 *
 * @author boniface
 */
@Configuration
@ComponentScan("zm.hashcode.tics")
@EnableMongoRepositories(basePackages = "zm.hashcode.tics.repository")
public class RepositoryConfig extends AbstractMongoConfiguration {
    

    @Override
    protected String getDatabaseName() {
        return "tics";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Mongo();
    }

    @Override
    protected String getMappingBasePackage() {
        return "zm.hashcode.tics.repository";
    }

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }
}
