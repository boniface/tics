/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.util;

import zm.hashcode.tics.client.web.content.training.institutions.model.TrainingInstructorBean;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;

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
}
