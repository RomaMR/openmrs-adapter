package org.openmrs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DefaultConfig {

    @Bean(name = "defaultRestTemplate")
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(jacksonMessageConverter());
        return restTemplate;
    }

    @Bean
    protected HttpMessageConverter<?> jacksonMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

}
