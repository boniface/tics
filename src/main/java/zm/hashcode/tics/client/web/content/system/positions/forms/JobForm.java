/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.FormLayout;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.job.JobClassificationFacade;
import zm.hashcode.tics.app.facade.ui.position.PositionFacade;
import zm.hashcode.tics.client.web.content.system.positions.model.JobBean;
import zm.hashcode.tics.domain.ui.job.JobClassification;
import zm.hashcode.tics.domain.ui.position.Position;

/**
 *
 * @author geek
 */
public class JobForm extends FormLayout {

    private final JobBean bean;
    public final BeanItem<JobBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    //
    public ListSelect positionList = new ListSelect();
    public ComboBox jobClassificationCombo = new ComboBox();

    public JobForm() {
        bean = new JobBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);
//        private String id;
//    private String title;
//    private String code;
//    private String description;
//    @DBRef
//    private JobClassification jobClassificationCombo; // jobClassificationId
//    @DBRef
//    private List<Position> positions; // positionIds

        TextField title = getTextField("Title", "title");
        TextField code = getTextField("Code", "code");
        TextField description = getTextField("Description", "description");
        final ListSelect positionIds = getPositionListSelect("Select Positions", "positionIds");
        ComboBox jobClassificationId = getJobClassificationComboBox("Job Classification", "jobClassificationId");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(title, 0, 0);
        grid.addComponent(code, 0, 1);
        grid.addComponent(description, 0, 2);

        grid.addComponent(jobClassificationId, 1, 0);
        grid.addComponent(positionIds, 1, 1);

        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);

    }

    private ListSelect getPositionListSelect(String label, String field) {
        positionList.setCaption(label);
        List<Position> allPositions = PositionFacade.getPositionService().findAll();
        for (Position iPosition : allPositions) {
            positionList.setItemCaption(iPosition.getId(), iPosition.getPositionTitle() + " " + iPosition.getPositionCode());
            positionList.addItem(iPosition.getId());
            positionList.setNullSelectionAllowed(false);
            positionList.setMultiSelect(true);

        }
        positionList.setWidth("250px");
        binder.bind(positionList, field);

        return positionList;
    }

    private ComboBox getJobClassificationComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        jobClassificationCombo.setCaption(label);
        List<JobClassification> allJobClassifications = JobClassificationFacade.getJobClassificationService().findAll();
        for (JobClassification iJobClassification : allJobClassifications) {
            jobClassificationCombo.addItem(iJobClassification.getId());
            jobClassificationCombo.setItemCaption(iJobClassification.getId(), iJobClassification.getCurrentTitle() + " " + iJobClassification.getCurrentCode());
        }

        jobClassificationCombo.addValidator(new BeanValidator(JobBean.class, field));
        jobClassificationCombo.setImmediate(true);
        jobClassificationCombo.setWidth(250, Unit.PIXELS);
        binder.bind(jobClassificationCombo, field);
        return jobClassificationCombo;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(JobBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);

        return buttons;
    }
}
