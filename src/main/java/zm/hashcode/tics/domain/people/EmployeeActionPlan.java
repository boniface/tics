/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public class EmployeeActionPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String courseId;
    private String schduledCourseId;
    private String actionPlan;
    private Date actionPlanDate;
    private Date reviewPlanDate;
    private String actionPlanreview;
    private String status;
    private boolean review;
    private String mentoringSessionId;
    private String nimmartSessionId;

    private EmployeeActionPlan() {
    }

    private EmployeeActionPlan(Builder builder) {
        id = builder.id;
        courseId = builder.courseId;
        schduledCourseId = builder.schduledCourseId;
        actionPlan = builder.actionPlan;
        actionPlanDate= builder.actionPlanDate;
        reviewPlanDate=builder.reviewPlanDate;
        actionPlanreview=builder.actionPlanreview;
        status=builder.status;
        review=builder.review;
        mentoringSessionId=builder.mentoringSessionId;
        nimmartSessionId=builder.nimmartSessionId;

    }

    public static class Builder {

        private final String actionPlan;
        private String id;
        private String courseId;
        private String schduledCourseId;
        private Date actionPlanDate;
        private Date reviewPlanDate;
        private String actionPlanreview;
        private String status;
        private boolean review;
        private String mentoringSessionId;
        private String nimmartSessionId;

        public Builder(String val) {
            this.actionPlan = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder courseId(String value) {
            courseId = value;
            return this;
        }
        
        public Builder schduledCourseId(String value) {
            schduledCourseId = value;
            return this;
        }
        
        public Builder actionPlanDate(Date value) {
            actionPlanDate = value;
            return this;
        }
        
        public Builder reviewPlanDate(Date value) {
            reviewPlanDate = value;
            return this;
        }
        
        public Builder actionPlanreview(String value) {
            actionPlanreview = value;
            return this;
        }
        
        public Builder status(String value) {
            status = value;
            return this;
        }
        
        public Builder review(Boolean value) {
            review = value;
            return this;
        }
        
        public Builder mentoringSessionId(String value) {
            mentoringSessionId = value;
            return this;
        }
        
        public Builder nimmartSessionId(String value) {
            nimmartSessionId = value;
            return this;
        }

    

        public EmployeeActionPlan build() {
            return new EmployeeActionPlan(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getSchduledCourseId() {
        return schduledCourseId;
    }

    public String getActionPlan() {
        return actionPlan;
    }

    public Date getActionPlanDate() {
        return actionPlanDate;
    }

    public Date getReviewPlanDate() {
        return reviewPlanDate;
    }

    public String getActionPlanreview() {
        return actionPlanreview;
    }

    public String getStatus() {
        return status;
    }

    public boolean isReview() {
        return review;
    }

    public String getMentoringSessionId() {
        return mentoringSessionId;
    }

    public String getNimmartSessionId() {
        return nimmartSessionId;
    }

    @Override
    public String toString() {
        return "EmployeeActionPlan{" + "id=" + id + ", actionPlan=" + actionPlan + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmployeeActionPlan other = (EmployeeActionPlan) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
