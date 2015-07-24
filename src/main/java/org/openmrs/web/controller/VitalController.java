package org.openmrs.web.controller;

import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.vital.Vital;
import org.openmrs.service.vital.VitalService;
import org.openmrs.web.dto.VitalDTO;
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
@RequestMapping("/api/vital")
public class VitalController extends BaseController{
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Vital> create(@RequestBody VitalDTO vitalDTO) {
        LOGGER.info("REST request to create vital");
        Vital vital = vitalService.createVital(vitalDTO);
        return new ResponseEntity<Vital>(vital, HttpStatus.CREATED
        );
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public ResponseEntity<Vital> update(@PathVariable("uuid") String uuid, @RequestBody VitalDTO vitalDTO) {
        LOGGER.info("REST request to update vital");
        vitalDTO.setUuid(uuid);
        Vital vital = vitalService.updateVital(uuid, vitalDTO);
        return new ResponseEntity<Vital>(vital, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("uuid") String uuid, @RequestParam(value = "purge") Boolean purge) {
        LOGGER.info("REST request to delete vital");

        vitalService.deleteVital(uuid, purge);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
