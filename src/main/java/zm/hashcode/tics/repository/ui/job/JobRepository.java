/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.ui.job;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.ui.job.Job;

/**
 *
 * @author boniface
 */

public interface JobRepository extends PagingAndSortingRepository<Job, String> {
   
}
