/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.tabs;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.app.facade.offices.ClusterFacade;
import zm.hashcode.tics.app.facade.offices.FacilityGroupingFacade;
import zm.hashcode.tics.app.facade.offices.NodeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.facility.FacilityMenu;
import zm.hashcode.tics.client.web.content.system.facility.forms.FacilityGroupingForm;
import zm.hashcode.tics.client.web.content.system.facility.model.FacilityGroupingBean;
import zm.hashcode.tics.client.web.content.system.facility.tables.FacilityGroupingTable;
import zm.hashcode.tics.client.web.content.system.facility.util.FacilityGroupingUtil;
import zm.hashcode.tics.domain.offices.Cluster;

import zm.hashcode.tics.domain.offices.FacilityGrouping;
import zm.hashcode.tics.domain.offices.Node;

/**
 *
 * @author Ferox
 */
public final class FacilityGroupingTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final FacilityGroupingForm form;
    private final FacilityGroupingTable table;
//    private Collection<String> rolesIds = new HashSet<>();
//    private Collection<String> jusrisdicationIds = new HashSet<>();
    private String clusterId;
    private String nodeId;

    public FacilityGroupingTab(TicsMain app) {
        main = app;
        form = new FacilityGroupingForm();
        table = new FacilityGroupingTable(main);
        setSizeFull();
        addComponent(form);
        addComponent(table);
        addListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.save) {
            saveForm(form.binder);
        } else if (source == form.edit) {
            setEditFormProperties();
        } else if (source == form.cancel) {
            getHome();
        } else if (source == form.update) {
            saveEditedForm(form.binder);
        } else if (source == form.delete) {
            deleteForm(form.binder);
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            final FacilityGrouping facilityGrouping = FacilityGroupingFacade.getFacilityGroupingService().find(table.getValue().toString());
            final FacilityGroupingBean bean = new FacilityGroupingUtil().getBean(facilityGrouping);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.clusterList) {
            clusterId = property.getValue().toString();
            System.out.println("Na ya Cluster selected value this: " + clusterId);
        } else if (property == form.nodeList) {
            nodeId = property.getValue().toString();
            System.out.println("Na ya Node selected value this: " + nodeId);
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            FacilityGroupingFacade.getFacilityGroupingService().persist(getNewEntity(binder));
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            System.out.println(e);
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveEditedForm(FieldGroup binder) {
        try {
            binder.commit();
            FacilityGroupingFacade.getFacilityGroupingService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        FacilityGroupingFacade.getFacilityGroupingService().remove(getUpdateEntity(binder));
        getHome();
    }

    private FacilityGrouping getNewEntity(FieldGroup binder) {
        final FacilityGroupingBean bean = ((BeanItem<FacilityGroupingBean>) binder.getItemDataSource()).getBean();
        Cluster cluster = ClusterFacade.getClusterService().find(clusterId);
        Node node = NodeFacade.getNodeService().find(nodeId);
        System.out.println(cluster.getClusterName() + node.getNodeName() + " is What have you selected?");
        System.out.println(bean.getClusterId() + bean.getNodeId() + " is What have bean got?");
//        final FacilityGrouping facilityGrouping = new FacilityGrouping.Builder(bean.getCluster())
        final FacilityGrouping facilityGrouping = new FacilityGrouping.Builder(cluster)
                //                .node(bean.getNode())
                .node(node)
                .build();
        return facilityGrouping;
    }

    private FacilityGrouping getUpdateEntity(FieldGroup binder) {
        final FacilityGroupingBean bean = ((BeanItem<FacilityGroupingBean>) binder.getItemDataSource()).getBean();
        Cluster cluster = ClusterFacade.getClusterService().find(clusterId);
        Node node = NodeFacade.getNodeService().find(nodeId);
//        final FacilityGrouping user = new FacilityGrouping.Builder(bean.getCluster())
        final FacilityGrouping facilityGrouping = new FacilityGrouping.Builder(cluster)
                .node(node)
                .id(bean.getId())
                .build();
        return facilityGrouping;


    }

    private void getHome() {
        main.content.setSecondComponent(new FacilityMenu(main, "GROUPING"));
    }

    private void setEditFormProperties() {
        form.binder.setReadOnly(false);
        form.save.setVisible(false);
        form.edit.setVisible(false);
        form.cancel.setVisible(true);
        form.delete.setVisible(false);
        form.update.setVisible(true);
    }

    private void setReadFormProperties() {
        form.binder.setReadOnly(true);
        //Buttons Behaviou
        form.save.setVisible(false);
        form.edit.setVisible(true);
        form.cancel.setVisible(true);
        form.delete.setVisible(true);
        form.update.setVisible(false);
    }

    private void addListeners() {
        //Register Button Listeners
        form.save.addClickListener((ClickListener) this);
        form.edit.addClickListener((ClickListener) this);
        form.cancel.addClickListener((ClickListener) this);
        form.update.addClickListener((ClickListener) this);
        form.delete.addClickListener((ClickListener) this);
        //Register Table Listerners
        table.addValueChangeListener((ValueChangeListener) this);
        form.clusterList.addValueChangeListener((ValueChangeListener) this);
        form.nodeList.addValueChangeListener((ValueChangeListener) this);
    }
}
