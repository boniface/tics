/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author boniface
 */
@Document
public class Course implements Serializable,Comparable<Course> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String courseName;
    private TrainingCourseCategory courseCategory;
    private String courseTopic;
    private TrainingInstitution institutionName;
    @DBRef
    private Status courseStatus;
    private String courseObjective;
    private CourseTypeName courseType;
  
    private List<CourseCompetencies> courseCompetencies;
    private List<CourseTargetGroup> courseTargetGroup;
    private CourseCriteria courseCriteria;
    private String notes;
    
    
 
    @Override
    public int compareTo(Course o) {
       return courseName.compareTo(o.courseName);
    }

    
    
}
