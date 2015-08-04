package org.openmrs.config;

import org.openmrs.service.security.DefaultSessionService;
import org.openmrs.service.security.SessionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by romanmudryi on 04.08.15.
 */
@Configuration
public class ServiceConfig {

    @Value("${openmrs.username}")
    private String openmrsUsername;

    @Value("${openmrs.password}")
    private String openmrsPassword;

    @Bean(name = "sessionService")
    public SessionService sessionService() {
        DefaultSessionService sessionService = new DefaultSessionService();

        sessionService.setOpenmrsPassword(openmrsPassword);
        sessionService.setOpenmrsUsername(openmrsUsername);

        return sessionService;
    }

}
