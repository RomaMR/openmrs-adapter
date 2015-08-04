package org.openmrs.web.controller;

import org.openmrs.service.content.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by romanmudryi on 29.07.15.
 */
@RestController
@RequestMapping("/api/contents")
public class ContentController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);

    @Resource(name = "contentService")
    private ContentService contentService;

    @RequestMapping(value = "{uuid}/{mime}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> get(@PathVariable("uuid") String uuid, @PathVariable("mime") String mime) throws
    IOException {
        LOGGER.info("REST request to get content");

        byte[] file = contentService.getContent(uuid + "/" + mime);
        return new ResponseEntity<byte[]>(file, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected ResponseEntity<String> post(@RequestParam(value = "patientId", required = true) String patientId, @RequestParam(value = "encounterId",
            required = true) String encounterId, @RequestParam(value = "file", required = true) MultipartFile file)
            throws IOException {
        LOGGER.info("REST request to save content");
        String uuid = contentService.saveContent(patientId, encounterId, file.getInputStream(), file.getOriginalFilename());
        return new ResponseEntity<String>(uuid, HttpStatus.OK);
    }

    @RequestMapping(value = "{uuid}/{mime}", method = RequestMethod.DELETE)
    protected ResponseEntity<Void> delete(@PathVariable("uuid") String uuid, @PathVariable("mime") String mime){
        LOGGER.info("REST request to delete content");

        contentService.deleteContent(uuid + "/" + mime);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
