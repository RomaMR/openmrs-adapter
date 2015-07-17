package org.openmrs.service.rest;

import org.openmrs.domain.user.User;
import org.openmrs.security.SecurityUtils;
import org.openmrs.service.security.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by romanmudryi on 16.07.15.
 */
@Component("restTemplateService")
public class DefaultRestTemplateService implements RestTemplateService{
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRestTemplateService.class);

    @Resource(name = "defaultRestTemplate")
    private RestTemplate restTemplate;

    @Resource(name = "sessionService")
    private SessionService sessionService;

    @Override
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, Class<T> responseType) throws RestClientException {
        LOGGER.info("Preparing call");

        HttpHeaders headers = getHttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return restTemplate.exchange(url , method, entity, responseType);
    }

    @Override
    public <O, T> ResponseEntity<T> exchangePOST(String url, HttpMethod method, O object, Class<T> responseType) throws RestClientException {
        LOGGER.info("Preparing call");

        HttpHeaders headers = getHttpHeaders();

        HttpEntity<O> entity = new HttpEntity<O>(object, headers);
        return restTemplate.exchange(url , method, entity, responseType);
    }

    private HttpHeaders getHttpHeaders() {
        User user = sessionService.getSessionUser();
        String base64 = SecurityUtils.getBase64(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Basic " + base64);

        return headers;
    }

}
