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

public class CourseTargetGroup implements Serializable {
   @DBRef
   private TargetGroup targetGroup;
   
}
