/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.training.mentoring;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.training.mentoring.MentoringSubjectArea;

/**
 *
 * @author geek
 */
public interface MentoringAreasListRepository extends PagingAndSortingRepository<MentoringSubjectArea, String> {
}
