package org.openmrs.web.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.openmrs.web.controller.BaseController;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public abstract class AbstractControllerTest {

    protected MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() {

        this.mockMvc = MockMvcBuilders.standaloneSetup(getUnit())
                .setValidator(getValidator())
                .alwaysDo(print())
                .build();
    }

    private LocalValidatorFactoryBean getValidator() {
        return new LocalValidatorFactoryBean();
    }

    protected abstract BaseController getUnit();

    /**
     * Method for configuring object mapper to write from fields
     * or from getters.
     * @param flag flag
     */
    private void writeFromFields(final boolean flag) {
        if (flag) {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            objectMapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
            objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        } else {

            objectMapper = new ObjectMapper();

        }
    }

    /**
     * Get's serialized json from resource.
     * @param object object.
     * @param writeFromFields write from fields
     * @return String json.
     * @throws JsonProcessingException exception, that can be throwned.
     */
    protected String getJson(final Object object, final boolean writeFromFields) throws JsonProcessingException {
        writeFromFields(writeFromFields);
        return objectMapper.writeValueAsString(object);
    }

    /**
     * Method for getting json using getters
     * @param object
     * @return
     * @throws Exception
     */
    protected String getJson(final Object object) throws Exception {
        writeFromFields(false);
        return objectMapper.writeValueAsString(object);
    }

}
