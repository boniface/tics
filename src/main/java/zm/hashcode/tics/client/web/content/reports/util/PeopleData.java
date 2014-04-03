/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.util;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.report.ReportFacade;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.client.web.content.home.tabs.FacilitiesStatsTab;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.reports.Report;
import zm.hashcode.tics.domain.training.course.Course;

/**
 *
 * @author boniface
 */
public class PeopleData implements Serializable {

    public List<Report> getReportData(ReportQuery query) {
        List<Report>  report =ReportFacade.getReportService().findAll();
        
        List<Report> data = report.stream()
                .filter(r->r.getStartDate().after(query.getStartDate())&& r.getEndDate().before(query.getEndDate()))
                .collect(Collectors.toList());
        
        
        if(query.getFacilityId()!=null && query.getCourseId()==null){
            Facility facility = FacilityFacade.getFacilityService().find(query.getFacilityId());
            return data.stream().filter(d->d.getFacility().equalsIgnoreCase(facility.getFacilityName()))
                    .collect(Collectors.toList());
            
        }
        
         if(query.getFacilityId()!=null && query.getCourseId()!=null){
            Facility facility = FacilityFacade.getFacilityService().find(query.getFacilityId());
            Course course = CourseFacade.getCourseService().find(query.getCourseId());
            return data.stream().filter(d->d.getFacility().equalsIgnoreCase(facility.getFacilityName()) && d.getCourseName().equalsIgnoreCase(course.getName()))
                    .collect(Collectors.toList());
            
        }
       
        System.out.println(" The Query For facility is  " + query.getFacilityId());
        System.out.println(" The Query  For Location Type is  " + query.getLocationTypeId());
        System.out.println(" The Query For Location is  " + query.getLocationId());

        System.out.println(" The Query For Prefessional is  " + query.getProfessionId());
        System.out.println(" The Query For Competrency is  " + query.getCourseId());
 
        return data;

    }
}
