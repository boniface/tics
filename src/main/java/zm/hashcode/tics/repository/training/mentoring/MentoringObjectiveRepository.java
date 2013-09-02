/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.training.mentoring;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.training.mentoring.MentoringObjective;

/**
 *
 * @author geek
 */
public interface MentoringObjectiveRepository extends PagingAndSortingRepository<MentoringObjective, String> {
}
