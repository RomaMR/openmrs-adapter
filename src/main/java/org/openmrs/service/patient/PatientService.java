package org.openmrs.service.patient;

import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.web.dto.PatientDTO;

public interface PatientService {

    Patient getPatient(String uuid);

    TemplateResults getPatients(String query);

    Patient createPatient(PatientDTO patientDTO);

    Patient updatePatient(String uuid, PatientDTO patientDTO);
}
