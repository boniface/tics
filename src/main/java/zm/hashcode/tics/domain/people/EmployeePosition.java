/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.ui.position.Position;

/**
 *
 * @author boniface
 */
public class EmployeePosition implements Serializable {

    private static long serialVersionUID = 1L;
    @DBRef
    private Position position;
    private Date startDate;
    private Date enddate;
    private String status;

    private EmployeePosition() {
    }

    private EmployeePosition(Builder builder) {
        position = builder.position;
        startDate = builder.startDate;
        enddate = builder.enddate;
        status = builder.status;
    }

    public static class Builder {

        private final Position position;
        private Date startDate;
        private Date enddate;
        private String status;

        public Builder(Position val) {
            this.position = val;
        }

        public Builder startDate(Date value) {
            startDate = value;
            return this;
        }

        public Builder enddate(Date value) {
            enddate = value;
            return this;
        }

        public Builder status(String value) {
            status = value;
            return this;
        }

        public EmployeePosition build() {
            return new EmployeePosition(this);
        }
    }

    public Position getPosition() {
        return position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public String getStatus() {
        return status;
    }
}
