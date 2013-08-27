/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.client.web.content.system.positions.model.PositionBean;
import zm.hashcode.tics.domain.offices.Department;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.ui.job.Job;
import zm.hashcode.tics.domain.ui.position.Position;
import zm.hashcode.tics.domain.ui.position.PositionType;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author geek
 */
public class PositionUtil {

    public PositionBean getBean(Position position) {
        PositionBean bean = new PositionBean();
        bean.setId(position.getId());
//        bean.setDepartmentId(getDepartmentId(position.getDepartment()));
        bean.setDescription(position.getDescription());
//        bean.setFacilityId(getFacilityId(position.getFacility()));
        bean.setJobId(getJobId(position.getJob()));
//        bean.setPersonId(getCurrentOccupantId(position.getCurrentOccupant()));
        bean.setPositionCode(position.getPositionCode());
        bean.setPositionComments(position.getPositionComments());
//        bean.setPositionEndDate(position.getPositionEndDate());
        bean.setPositionEntryDate(position.getPostionEntryDate());
        bean.setPositionId(getSupervisorId(position.getSupervisor()));
        bean.setPositionTitle(position.getPositionTitle());
        bean.setPositionTypeId(getPositionTypeId(position.getPositionType()));
        bean.setStatusId(getPositionStatusId(position.getPositionStatus()));
        bean.setSubodinateIds(getSubordinateIds(position.getSubodinateIds()));
        return bean;
    }

    public String getDepartmentId(Department department) {
        if (department.getId() != null) {
            return department.getId();
        }

        return null;
    }

    public String getFacilityId(Facility facility) {
        return facility.getId();
    }

    public String getJobId(Job job) {
        return job.getId();
    }

    public String getCurrentOccupantId(Person person) {
        return person.getId();
    }

    public String getSupervisorId(Position position) {
        try {
            if (position.getId() != null) {
                return position.getId();
            }
        } catch (NullPointerException ex) {
            return null;
        }
        return null;

    }

    public String getPositionTypeId(PositionType positionType) {
        return positionType.getId();
    }

    public String getPositionStatusId(Status status) {
        return status.getId();
    }

    public Set<String> getSubordinateIds(List<String> idz) {

        try {
            if (idz != null) {
                Set<String> ids = new HashSet<>(idz);
                return ids;
            }
        } catch (NullPointerException ex) {
            return null;
        }
        return null;

    }
}
