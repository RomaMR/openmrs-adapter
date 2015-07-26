package org.openmrs.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by romanmudryi on 17.07.15.
 */
@ControllerAdvice
public class AutenticationExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutenticationExceptionHandler.class);

    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<String> exception(Exception exception, WebRequest request) {
        LOGGER.info("Bad credentials");
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
}
