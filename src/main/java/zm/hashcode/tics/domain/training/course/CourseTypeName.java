/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.training.course;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public class CourseTypeName implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String courseType;

    
}
