/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.ui.job;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.ui.position.Position;

/**
 *
 * @author boniface
 */
@Document
public class Job implements Serializable, Comparable<Job>{
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String title;
    private String code ;
    private String description;
    @DBRef
    private JobClassification jobClassification;
    @DBRef
    private List<Position> positions;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
    
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public JobClassification getJobClassification() {
        return jobClassification;
    }

    public void setJobClassification(JobClassification jobClassification) {
        this.jobClassification = jobClassification;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.jobs.Jobs[id=" + id + "]";
    }
    @Override
    public int compareTo(Job o) {
        return title.compareTo(o.title);
    }

    


    
}
