package org.openmrs.service.vital;

import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.vital.Vital;
import org.openmrs.service.rest.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by romanmudryi on 16.07.15.
 */
@Component("vitalService")
public class DefaultVitalService implements VitalService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultVitalService.class);

    @Resource(name = "restTemplateService")
    private RestTemplateService restTemplateService;

    @Value("${openmrs.host.rest}")
    private String host;

    @Override
    public Vital getVital(String uuid) {
        LOGGER.info("getting vitals");

        ResponseEntity<Vital> result = restTemplateService.exchange(host + "/obs/" + uuid, HttpMethod.GET, Vital.class);
        return result.getBody();
    }

    @Override
    public TemplateResults getVitals(String patientUUID) {
        LOGGER.info("getting all vitals");

        ResponseEntity<TemplateResults> result = restTemplateService.exchange(host + "/obs?patient=" + patientUUID, HttpMethod.GET, TemplateResults
                .class);
        return result.getBody();
    }
}

