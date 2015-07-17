package org.openmrs.web.controller;

import com.wordnik.swagger.annotations.Api;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.vital.Vital;
import org.openmrs.service.vital.VitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by romanmudryi on 16.07.15.
 */
@RestController
@Api(basePath = "/vital", value = "vital", description = "Operations with Vital", produces = "application/json")
@RequestMapping("/api/vital")
public class VitalController {
    private static final Logger LOGGER = LoggerFactory.getLogger(VisitController.class);

    @Resource(name = "vitalService")
    private VitalService vitalService;

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<Vital> get(@PathVariable("uuid") String uuid) {
        LOGGER.info("REST request to get vital");

        Vital vital = vitalService.getVital(uuid);
        return new ResponseEntity<Vital>(vital, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<TemplateResults> getAll(@RequestParam(value = "patient") String patientUUID) {
        LOGGER.info("REST request to get all vitals");

        TemplateResults vitals = vitalService.getVitals(patientUUID);
        return new ResponseEntity<TemplateResults>(vitals, HttpStatus.OK);
    }
}
