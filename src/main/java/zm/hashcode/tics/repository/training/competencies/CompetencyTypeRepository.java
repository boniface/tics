/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.training.competencies;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.training.competencies.CompetencyType;

/**
 *
 * @author boniface
 */

public interface CompetencyTypeRepository extends PagingAndSortingRepository<CompetencyType, String> {
   
}
