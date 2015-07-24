package org.openmrs.service.patient;

import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.service.rest.RestTemplateService;
import org.openmrs.web.dto.PatientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("patientService")
public class DefaultPatientService implements PatientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPatientService.class);

    @Resource(name = "restTemplateService")
    private RestTemplateService restTemplateService;

    private String host;

    @Value("${openmrs.host.rest}")
    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public Patient getPatient(String uuid) {
        LOGGER.info("getting patient");

        ResponseEntity<Patient> result = restTemplateService.exchange(host + "/patient/" + uuid, HttpMethod.GET, Patient.class);
        return result.getBody();
    }

    @Override
    public TemplateResults getPatients(String query) {
        LOGGER.info("getting all patients");

        ResponseEntity<TemplateResults> result = restTemplateService.exchange(host + "/patient?q=" + query, HttpMethod.GET, TemplateResults.class);
        return result.getBody();
    }

    @Override
    public Patient createPatient(PatientDTO patientDTO) {
        LOGGER.info("creating person");

        ResponseEntity<Patient> result = restTemplateService.exchangePOST(host + "/patient", HttpMethod.POST, patientDTO, Patient.class);
        return result.getBody();
    }

    @Override
    public Patient updatePatient(String uuid, PatientDTO patientDTO) {
        LOGGER.info("updating person");
        patientDTO.setUuid(uuid);

        ResponseEntity<Patient> result = restTemplateService.exchangePOST(host + "/patient", HttpMethod.POST, patientDTO, Patient.class);
        return result.getBody();
    }
}
