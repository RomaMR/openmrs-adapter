package org.openmrs.service.vital;

import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.vital.Vital;
import org.openmrs.web.dto.VitalDTO;

/**
 * Created by romanmudryi on 16.07.15.
 */
public interface VitalService {

    Vital getVital(String uuid);

    TemplateResults getVitals(String patientUUID);

    Vital createVital(VitalDTO vitalDTO);

    Vital updateVital(String uuid, VitalDTO vitalDTO);

    void deleteVital(String uuid, Boolean purge);
}
