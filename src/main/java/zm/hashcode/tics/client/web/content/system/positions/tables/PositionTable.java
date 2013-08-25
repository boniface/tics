/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.tables;

import com.vaadin.ui.Table;
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.position.PositionFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.position.Position;

/**
 *
 * @author geek
 */
public class PositionTable extends Table {

    private final TicsMain main;

    public PositionTable(TicsMain main) {
        this.main = main;
        setSizeFull();

//        private String id;
//    private String positionCode;
//    //Make it from Job and Position Title Nurse-Code
//    private String positionTitle;
//    private String description;
//    private Date postionEntryDate;
//    private Date positionEndDate;
//    @DBRef
//    private Person currentOccupant;
//    @DBRef
//    private PositionType positionType;
//    @DBRef
//    private Status positionStatus;
//    private String positionComments;
//    @DBRef
//    private Facility facility;
//    private List<String> subodinateIds;
//    @DBRef
//    private Position supervisor;
//    @DBRef
//    private Department department;
//    @DBRef
//    private Job job;

        addContainerProperty("Position Code", String.class, null);
        addContainerProperty("Position Title", String.class, null);
        addContainerProperty("Description", String.class, null);
        addContainerProperty("Position Entry Date", Date.class, null);
//        addContainerProperty("Position End Date", Date.class, null);
        addContainerProperty("Position Comments", String.class, null);

        List<Position> positionList = PositionFacade.getPositionService().findAll();
        for (Position iPosition : positionList) {
            addItem(new Object[]{iPosition.getPositionCode(),
                iPosition.getPositionTitle(),
                iPosition.getDescription(),
                iPosition.getPostionEntryDate(),
                //                iPosition.getPositionEndDate(),
                iPosition.getPositionComments()
            }, iPosition.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }
}
