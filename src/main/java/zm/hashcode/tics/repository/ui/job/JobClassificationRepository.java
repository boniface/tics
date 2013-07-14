/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.ui.job;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.ui.job.JobClassification;

/**
 *
 * @author boniface
 */

public interface JobClassificationRepository extends PagingAndSortingRepository<JobClassification, String> {
   
}
