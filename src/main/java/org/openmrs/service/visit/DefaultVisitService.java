package org.openmrs.service.visit;

import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.visit.Visit;
import org.openmrs.service.rest.RestTemplateService;
import org.openmrs.web.dto.VisitDTO;
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
@Component("visitService")
public class DefaultVisitService implements VisitService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultVisitService.class);

    @Resource(name = "restTemplateService")
    private RestTemplateService restTemplateService;

    private String host;

    @Value("${openmrs.host.rest}")
    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public Visit getVisit(String uuid) {
        LOGGER.info("getting visit");

        ResponseEntity<Visit> result = restTemplateService.exchange(host + "/visit/" + uuid, HttpMethod.GET, Visit.class);
        return result.getBody();
    }

    @Override
    public TemplateResults getVisits(String patientUUID) {
        LOGGER.info("getting all visit");

        ResponseEntity<TemplateResults> result = restTemplateService.exchange(host + "/visit?patient=" + patientUUID, HttpMethod.GET, TemplateResults
                .class);
        return result.getBody();
    }

    @Override
    public Visit createVisit(VisitDTO visitDTO) {
        LOGGER.info("creating visit");

        ResponseEntity<Visit> result = restTemplateService.exchangePOST(host + "/visit", HttpMethod.POST, visitDTO, Visit.class);
        return result.getBody();
    }

    @Override
    public Visit updateVisit(String uuid, VisitDTO visitDTO) {
        LOGGER.info("updating visit");

        ResponseEntity<Visit> result = restTemplateService.exchangePOST(host + "/visit/" + uuid, HttpMethod.POST, visitDTO, Visit.class);
        return result.getBody();
    }

}
