/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author geek
 */
public class DateUtil implements Serializable {

    public Date resetTimeOfDate(Date inDate) {
        // resets the time in a date to zero e.g. Mon Jul 02 23:03:54 SAST 2012
        // to Mon Jul 02 00:00:00 SAST 2012 because the time part makes a big difference btn two dates.
        // Can be used to compare to dates for equality, before or after
        // Get Calendar object set to the date and time of the given Date object
        Calendar cal = Calendar.getInstance();
        cal.setTime(inDate);

        // Set time fields to zero
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // Put it back in the Date object
        inDate = cal.getTime();

        return inDate;
    }
}
