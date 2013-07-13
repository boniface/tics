/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.course;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author boniface
 */

public class CourseCriteria implements Serializable {
   @DBRef
   private Criteria criteria;
    
}
