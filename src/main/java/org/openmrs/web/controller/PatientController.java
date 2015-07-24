package org.openmrs.web.controller;

import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.service.patient.PatientService;
import org.openmrs.web.dto.PatientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/patient")
public class PatientController extends BaseController{
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    @Resource(name = "patientService")
    private PatientService patientService;

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<Patient> get(@PathVariable("uuid") String uuid) {
        LOGGER.info("REST request to get patient");

        Patient patient = patientService.getPatient(uuid);
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<TemplateResults> getAll(@RequestParam(value = "query") String query) {
        LOGGER.info("REST request to get all patients");
        TemplateResults patients = patientService.getPatients(query);
        return new ResponseEntity<TemplateResults>(patients, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Patient> create(@RequestBody PatientDTO patientDTO) {
        LOGGER.info("REST request to create patient");
        Patient patient = patientService.createPatient(patientDTO);
        return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public ResponseEntity<Patient> update(@PathVariable("uuid") String uuid, @RequestBody PatientDTO patientDTO) {
        LOGGER.info("REST request to update patient");
        Patient patient = patientService.updatePatient(uuid, patientDTO);
        return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
    }

}
