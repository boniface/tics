/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.training.mentoring;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.training.mentoring.MentoringSessionTheme;

/**
 *
 * @author geek
 */
public interface MentoringSessionThemeRepository extends PagingAndSortingRepository<MentoringSessionTheme, String> {
}
