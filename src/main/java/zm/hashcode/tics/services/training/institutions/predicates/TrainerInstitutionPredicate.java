/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.institutions.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.app.security.GetUserCredentials;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;

/**
 *
 * @author boniface
 */
public class TrainerInstitutionPredicate implements Predicate<TrainingInstitution> {

    GetUserCredentials cred = new GetUserCredentials();

    @Override
    public boolean apply(TrainingInstitution institution) {

        if (institution.getUsers().contains(cred.getLoggedInUser())) {
            return true;
        }
        return false;
    }
}
