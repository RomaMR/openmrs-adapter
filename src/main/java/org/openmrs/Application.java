package org.openmrs;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.openmrs.config.DefaultConfig;
import org.openmrs.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "org.openmrs")
@EnableAutoConfiguration
@EnableSwagger
@SpringBootApplication
@PropertySource("classpath:application.properties")
@Configuration
@Import({
        DefaultConfig.class,
        SecurityConfig.class
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
