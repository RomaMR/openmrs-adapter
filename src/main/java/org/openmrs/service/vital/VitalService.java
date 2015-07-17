package org.openmrs.service.vital;

import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.vital.Vital;

/**
 * Created by romanmudryi on 16.07.15.
 */
public interface VitalService {

    Vital getVital(String uuid);

    TemplateResults getVitals(String patientUUID);
}
