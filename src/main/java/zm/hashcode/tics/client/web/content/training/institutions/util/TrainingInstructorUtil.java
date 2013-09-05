/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.util;

import com.google.common.collect.Collections2;
import java.util.Collection;
import java.util.List;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstitutionFacade;
import zm.hashcode.tics.client.web.content.training.institutions.model.TrainingInstructorBean;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.services.training.institutions.predicates.TrainerInstitutionPredicate;

/**
 *
 * @author geek
 */
public class TrainingInstructorUtil {

    public TrainingInstructorBean getBean(TrainingInstructors trainingInstructor) {
        TrainingInstructorBean bean = new TrainingInstructorBean();
        bean.setId(trainingInstructor.getId());
        bean.setAreaOfexpertise(trainingInstructor.getAreaOfexpertise());
        bean.setFirstName(trainingInstructor.getFirstName());
        bean.setLastName(trainingInstructor.getLastName());
        bean.setOtherName(trainingInstructor.getOtherName());
        bean.setQualification(trainingInstructor.getQualification());
        return bean;
    }

    public static TrainingInstitution getTrainingInstitution() {

        List<TrainingInstitution> trainingInstitutions = TrainingInstitutionFacade.getTrainingInstitutionService().findAll();
        Collection<TrainingInstitution> institutions = Collections2.filter(trainingInstitutions, new TrainerInstitutionPredicate());
        if (institutions.isEmpty()) {
            return null;
        } else {
            return institutions.iterator().next();
        }

    }
}
