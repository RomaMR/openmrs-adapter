package org.openmrs.web.controller;

import com.wordnik.swagger.annotations.Api;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.visit.Visit;
import org.openmrs.service.visit.VisitService;
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
@Api(basePath = "/visit", value = "visit", description = "Operations with Visit", produces = "application/json")
@RequestMapping("/api/visit")
public class VisitController {
    private static final Logger LOGGER = LoggerFactory.getLogger(VisitController.class);

    @Resource(name = "visitService")
    private VisitService visitService;

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<Visit> get(@PathVariable("uuid") String uuid) {
        LOGGER.info("REST request to get visit");

        Visit visit = visitService.getVisit(uuid);
        return new ResponseEntity<Visit>(visit, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<TemplateResults> getAll(@RequestParam(value = "patient") String patientUUID) {
        LOGGER.info("REST request to get all visits");

        TemplateResults visits = visitService.getVisits(patientUUID);
        return new ResponseEntity<TemplateResults>(visits, HttpStatus.OK);
    }

}
