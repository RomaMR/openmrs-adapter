package org.openmrs.web.controller;

import com.wordnik.swagger.annotations.Api;
import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.service.patient.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by romanmudryi on 15.07.15.
 */
@RestController
@Api(basePath = "/patient", value = "patient", description = "Operations with Patient", produces = "application/json")
@RequestMapping("/api/patient")
public class PatientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    @Resource(name = "patientService")
    private PatientService patientService;

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<Patient> get(@PathVariable("uuid") String uuid) {
        LOGGER.info("REST request to get patient");

        Patient patient = patientService.getPatient(uuid);
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<TemplateResults> getAll(@RequestParam(value = "query") String query) {
        LOGGER.info("REST request to get all patients");

        TemplateResults patients = patientService.getPatients(query);
        return new ResponseEntity<TemplateResults>(patients, HttpStatus.OK);
    }

}
