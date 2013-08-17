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
import static com.vaadin.server.Sizeable.UNITS_PIXELS;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import java.util.Collection;
import java.util.HashSet;
import zm.hashcode.tics.app.facade.offices.ClusterFacade;
import zm.hashcode.tics.app.facade.offices.NodeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.facility.FacilityMenu;
import zm.hashcode.tics.client.web.content.system.facility.forms.ClusterForm;
import zm.hashcode.tics.client.web.content.system.facility.forms.NodeForm;
import zm.hashcode.tics.client.web.content.system.facility.model.ClusterBean;
import zm.hashcode.tics.client.web.content.system.facility.model.NodeBean;
import zm.hashcode.tics.client.web.content.system.facility.tables.ClusterTable;
import zm.hashcode.tics.client.web.content.system.facility.tables.NodeTable;
import zm.hashcode.tics.client.web.content.system.facility.util.ClusterUtil;
import zm.hashcode.tics.client.web.content.system.facility.util.NodeUtil;
import zm.hashcode.tics.domain.offices.Cluster;
import zm.hashcode.tics.domain.offices.Node;

/**
 *
 * @author Ferox
 */
public final class NodeAndClusterTab extends GridLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final ClusterForm clusterForm;
    private final NodeForm nodeForm;
    private final ClusterTable clusterTable;
    private final NodeTable nodeTable;

    public NodeAndClusterTab(TicsMain app) {
        main = app;
        clusterForm = new ClusterForm();
        nodeForm = new NodeForm();
        clusterTable = new ClusterTable(main);
        nodeTable = new NodeTable(main);
        clusterTable.setWidth(300, UNITS_PIXELS);
        nodeTable.setWidth(300, UNITS_PIXELS);
        setSizeFull();
        setColumns(2);
        setRows(2);
        addComponent(clusterForm);
        addComponent(nodeForm);
        addComponent(clusterTable);
        addComponent(nodeTable);
        addClusterListeners();
        addNodeListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == clusterForm.save) {
            saveClusterForm(clusterForm.binder);
        } else if (source == nodeForm.save) {
            saveNodeForm(nodeForm.binder);
        } else if (source == clusterForm.edit) {
            setEditClusterFormProperties();
        } else if (source == nodeForm.edit) {
            setEditNodeFormProperties();
        } else if (source == clusterForm.cancel || source == nodeForm.cancel) {
            getHome();
        } else if (source == clusterForm.update) {
            saveEditedClusterForm(clusterForm.binder);
        } else if (source == nodeForm.update) {
            saveEditedNodeForm(nodeForm.binder);
        } else if (source == clusterForm.delete) {
            deleteClusterForm(clusterForm.binder);
        } else if (source == nodeForm.delete) {
            deleteNodeForm(nodeForm.binder);
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == clusterTable) {
            final Cluster cluster = ClusterFacade.getClusterService().find(clusterTable.getValue().toString());
            final ClusterBean bean = new ClusterUtil().getBean(cluster);
            clusterForm.binder.setItemDataSource(new BeanItem<>(bean));
            setReadClusterFormProperties();
        }

        if (property == nodeTable) {
            final Node node = NodeFacade.getNodeService().find(nodeTable.getValue().toString());
            final NodeBean bean = new NodeUtil().getBean(node);
            nodeForm.binder.setItemDataSource(new BeanItem<>(bean));
            setReadNodeFormProperties();
        }
    }

    private void saveClusterForm(FieldGroup binder) {
        try {
            binder.commit();
            ClusterFacade.getClusterService().persist(getNewClusterEntity(binder));
            getHome();
            Notification.show("Cluster Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Cluster Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveNodeForm(FieldGroup binder) {
        try {
            binder.commit();
            NodeFacade.getNodeService().persist(getNewNodeEntity(binder));
            getHome();
            Notification.show("Node Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("NOde Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveEditedClusterForm(FieldGroup binder) {
        try {
            binder.commit();
            ClusterFacade.getClusterService().merge(getUpdateClusterEntity(binder));
            getHome();
            Notification.show("Cluster Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Cluster Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveEditedNodeForm(FieldGroup binder) {
        try {
            binder.commit();
            NodeFacade.getNodeService().merge(getUpdateNodeEntity(binder));
            getHome();
            Notification.show("Node Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Node Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteClusterForm(FieldGroup binder) {
        ClusterFacade.getClusterService().remove(getUpdateClusterEntity(binder));
        getHome();
    }

    private void deleteNodeForm(FieldGroup binder) {
        NodeFacade.getNodeService().remove(getUpdateNodeEntity(binder));
        getHome();
    }

    private Cluster getNewClusterEntity(FieldGroup binder) {
        final ClusterBean bean = ((BeanItem<ClusterBean>) binder.getItemDataSource()).getBean();
        final Cluster cluster = new Cluster.Builder(bean.getClusterName())
                .build();
        return cluster;
    }

    private Node getNewNodeEntity(FieldGroup binder) {
        final NodeBean bean = ((BeanItem<NodeBean>) binder.getItemDataSource()).getBean();
        final Node node = new Node.Builder(bean.getNodeName())
                .build();
        return node;
    }

    private Cluster getUpdateClusterEntity(FieldGroup binder) {

        final ClusterBean bean = ((BeanItem<ClusterBean>) binder.getItemDataSource()).getBean();
        final Cluster cluster = new Cluster.Builder(bean.getClusterName())
                .id(bean.getId())
                .build();
        return cluster;
    }

    private Node getUpdateNodeEntity(FieldGroup binder) {

        final NodeBean bean = ((BeanItem<NodeBean>) binder.getItemDataSource()).getBean();
        final Node node = new Node.Builder(bean.getNodeName())
                .id(bean.getId())
                .build();
        return node;
    }

    private void getHome() {
        main.content.setSecondComponent(new FacilityMenu(main, "NODE"));
    }

    private void setEditClusterFormProperties() {
        clusterForm.binder.setReadOnly(false);
        clusterForm.save.setVisible(false);
        clusterForm.edit.setVisible(false);
        clusterForm.cancel.setVisible(true);
        clusterForm.delete.setVisible(false);
        clusterForm.update.setVisible(true);
    }

    private void setEditNodeFormProperties() {
        nodeForm.binder.setReadOnly(false);
        nodeForm.save.setVisible(false);
        nodeForm.edit.setVisible(false);
        nodeForm.cancel.setVisible(true);
        nodeForm.delete.setVisible(false);
        nodeForm.update.setVisible(true);
    }

    private void setReadClusterFormProperties() {
        clusterForm.binder.setReadOnly(true);
        //Buttons Behaviou
        clusterForm.save.setVisible(false);
        clusterForm.edit.setVisible(true);
        clusterForm.cancel.setVisible(true);
        clusterForm.delete.setVisible(true);
        clusterForm.update.setVisible(false);
    }

    private void setReadNodeFormProperties() {
        nodeForm.binder.setReadOnly(true);
        //Buttons Behaviou
        nodeForm.save.setVisible(false);
        nodeForm.edit.setVisible(true);
        nodeForm.cancel.setVisible(true);
        nodeForm.delete.setVisible(true);
        nodeForm.update.setVisible(false);
    }

    private void addClusterListeners() {
        //Register Button Listeners
        clusterForm.save.addClickListener((ClickListener) this);
        clusterForm.edit.addClickListener((ClickListener) this);
        clusterForm.cancel.addClickListener((ClickListener) this);
        clusterForm.update.addClickListener((ClickListener) this);
        clusterForm.delete.addClickListener((ClickListener) this);
        //Register Table Listerners
        clusterTable.addValueChangeListener((ValueChangeListener) this);
    }

    private void addNodeListeners() {
        //Register Button Listeners
        nodeForm.save.addClickListener((ClickListener) this);
        nodeForm.edit.addClickListener((ClickListener) this);
        nodeForm.cancel.addClickListener((ClickListener) this);
        nodeForm.update.addClickListener((ClickListener) this);
        nodeForm.delete.addClickListener((ClickListener) this);
        //Register Table Listerners
        nodeTable.addValueChangeListener((ValueChangeListener) this);
    }
}
