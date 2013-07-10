/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.job;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.ui.position.Position;

/**
 *
 * @author boniface
 */
@Document
public final class Job implements Serializable, Comparable<Job> {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String title;
    private String code;
    private String description;
    @DBRef
    private JobClassification jobClassification;
    @DBRef
    private List<Position> positions;

    private Job() {
    }

    private Job(Builder builder) {
        id = builder.id;
        title = builder.title;
        code = builder.code;
        description=builder.description;
        jobClassification=builder.jobClassification;
        positions=builder.positions;

    }

    public static class Builder {

        private String id;
        private final String title;
        private String code;
        private String description;
        private JobClassification jobClassification;
        private List<Position> positions;

        public Builder(String val) {
            this.title = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder code(String value) {
            code = value;
            return this;
        }

        public Builder jobClassification(JobClassification value) {
            jobClassification = value;
            return this;
        }

        public Builder description(String value) {
            description = value;
            return this;
        }

        public Builder positions(List<Position> value) {
            positions = value;
            return this;
        }

        public Job build() {
            return new Job(this);
        }
    }

    @Override
    public int compareTo(Job o) {
        return title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return "Job{" + "title=" + title + ", code=" + code + '}';
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public JobClassification getJobClassification() {
        return jobClassification;
    }

    public List<Position> getPositions() {
        return ImmutableList.copyOf(positions);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Job other = (Job) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }    
}
