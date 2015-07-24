package org.openmrs.web.controller;

import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.Resource;

/**
 * Created by romanmudryi on 23.07.15.
 */
public class BaseController {

    @Resource
    private Validator validator;

    /**
     * Default init binder method.
     * @param binder binder.
     */
    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        binder.setValidator(validator);
    }
}
