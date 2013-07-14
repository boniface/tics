/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.training.institutions;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;

/**
 *
 * @author boniface
 */

public interface TrainingInstitutionRepository extends PagingAndSortingRepository<TrainingInstitution, String> {
   
}
