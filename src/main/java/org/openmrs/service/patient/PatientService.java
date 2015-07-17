package org.openmrs.service.patient;

import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;

public interface PatientService {

    Patient getPatient(String uuid);

    TemplateResults getPatients(String query);

}
