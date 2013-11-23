/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author boniface
 */
public class PeopleData implements Serializable {

    public List<PeopleReport> getReportData(ReportQuery query) {

        System.out.println(" The Query For facility is  " + query.getFacilityId());
        System.out.println(" The Query  For Location Type is  " + query.getLocationTypeId());
        System.out.println(" The Query For Location is  " + query.getLocationId());

        System.out.println(" The Query For Prefessional is  " + query.getProfessionId());
        System.out.println(" The Query For Competrency is  " + query.getCourseId());

        List<PeopleReport> data = new ArrayList<>();

        return data;


    }
}
