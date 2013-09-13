/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author geek
 */
public class PersonActionPlanBean implements Serializable {

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

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the schduledCourseId
     */
    public String getSchduledCourseId() {
        return schduledCourseId;
    }

    /**
     * @param schduledCourseId the schduledCourseId to set
     */
    public void setSchduledCourseId(String schduledCourseId) {
        this.schduledCourseId = schduledCourseId;
    }

    /**
     * @return the actionPlan
     */
    public String getActionPlan() {
        return actionPlan;
    }

    /**
     * @param actionPlan the actionPlan to set
     */
    public void setActionPlan(String actionPlan) {
        this.actionPlan = actionPlan;
    }

    /**
     * @return the actionPlanDate
     */
    public Date getActionPlanDate() {
        return actionPlanDate;
    }

    /**
     * @param actionPlanDate the actionPlanDate to set
     */
    public void setActionPlanDate(Date actionPlanDate) {
        this.actionPlanDate = actionPlanDate;
    }

    /**
     * @return the reviewPlanDate
     */
    public Date getReviewPlanDate() {
        return reviewPlanDate;
    }

    /**
     * @param reviewPlanDate the reviewPlanDate to set
     */
    public void setReviewPlanDate(Date reviewPlanDate) {
        this.reviewPlanDate = reviewPlanDate;
    }

    /**
     * @return the actionPlanreview
     */
    public String getActionPlanreview() {
        return actionPlanreview;
    }

    /**
     * @param actionPlanreview the actionPlanreview to set
     */
    public void setActionPlanreview(String actionPlanreview) {
        this.actionPlanreview = actionPlanreview;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the review
     */
    public boolean isReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(boolean review) {
        this.review = review;
    }

    /**
     * @return the mentoringSessionId
     */
    public String getMentoringSessionId() {
        return mentoringSessionId;
    }

    /**
     * @param mentoringSessionId the mentoringSessionId to set
     */
    public void setMentoringSessionId(String mentoringSessionId) {
        this.mentoringSessionId = mentoringSessionId;
    }

    /**
     * @return the nimmartSessionId
     */
    public String getNimmartSessionId() {
        return nimmartSessionId;
    }

    /**
     * @param nimmartSessionId the nimmartSessionId to set
     */
    public void setNimmartSessionId(String nimmartSessionId) {
        this.nimmartSessionId = nimmartSessionId;
    }
}
