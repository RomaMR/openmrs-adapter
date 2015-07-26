package org.openmrs.service.rest;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

/**
 * Created by romanmudryi on 16.07.15.
 */
public interface RestTemplateAdapter {

    <T> ResponseEntity<T> exchange(String url, HttpMethod method, Class<T> responseType) throws RestClientException;

    <O, T> ResponseEntity<T> exchangePOST(String url, HttpMethod method, O object, Class<T> responseType) throws RestClientException;

}
