/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.people;

import com.hashthrims.domain.positions.Positions;
import java.io.Serializable;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author boniface
 */

public class EmployeePosition implements Serializable {
    private static long serialVersionUID = 1L;
    @DBRef
    private Positions position;
    private Date startDate;
    private Date enddate;
    private String status;
   
   

    /**
     * @return the position
     */
    public Positions getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Positions position) {
        this.position = position;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

   

    /**
     * @return the enddate
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * @param enddate the enddate to set
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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

}
