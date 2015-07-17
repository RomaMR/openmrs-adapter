package org.openmrs.service.visit;

import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.visit.Visit;

/**
 * Created by romanmudryi on 16.07.15.
 */
public interface VisitService {

    Visit getVisit(String uuid);

    TemplateResults getVisits(String patientUUID);
}
