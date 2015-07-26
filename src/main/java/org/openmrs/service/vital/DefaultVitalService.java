package org.openmrs.service.vital;

import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.vital.Vital;
import org.openmrs.service.rest.RestTemplateAdapter;
import org.openmrs.web.dto.VitalDTO;
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

    @Resource(name = "restTemplateAdapter")
    private RestTemplateAdapter restTemplateAdapter;

    private String host;

    @Value("${openmrs.host.rest}")
    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public Vital getVital(String uuid) {
        LOGGER.info("getting vitals");

        ResponseEntity<Vital> result = restTemplateAdapter.exchange(host + "/obs/" + uuid, HttpMethod.GET, Vital.class);
        return result.getBody();
    }

    @Override
    public TemplateResults getVitals(String patientUUID) {
        LOGGER.info("getting all vitals");

        ResponseEntity<TemplateResults> result = restTemplateAdapter.exchange(host + "/obs?patient=" + patientUUID, HttpMethod.GET, TemplateResults
                .class);
        return result.getBody();
    }

    @Override
    public Vital createVital(VitalDTO vitalDTO) {
        LOGGER.info("creating vital");

        ResponseEntity<Vital> result = restTemplateAdapter.exchangePOST(host + "/obs", HttpMethod.POST, vitalDTO, Vital.class);
        return result.getBody();
    }

    @Override
    public Vital updateVital(String uuid, VitalDTO vitalDTO) {
        LOGGER.info("updating vital");

        ResponseEntity<Vital> result = restTemplateAdapter.exchangePOST(host + "/obs/" + uuid, HttpMethod.POST, vitalDTO, Vital.class);
        return result.getBody();
    }

    @Override
    public void deleteVital(String uuid, Boolean purge) {
        LOGGER.info("deleting vital");

        String purgeString;
        if(purge){
            purgeString = "?purge";
        } else {
            purgeString = "?!purge";
        }
        restTemplateAdapter.exchange(host + "/obs/" + uuid + purgeString, HttpMethod.DELETE, Void.class);
    }
}

