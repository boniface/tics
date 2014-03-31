/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.home.tabs;

import com.vaadin.event.FieldEvents;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.home.tables.FacilityTableStats;
import zm.hashcode.tics.domain.offices.Facility;

/**
 *
 * @author boniface
 */
public class FacilitiesStatsTab extends VerticalLayout implements
        Button.ClickListener {

    private final TicsMain main;
    private final HorizontalLayout headerBar = new HorizontalLayout();
    public final VerticalLayout contentPanel = new VerticalLayout();
    private final TextField facilitiesSearchBox = new TextField("Search For Facility");
    private List<Facility> facilities = FacilityFacade.getFacilityService().findAll();
    private FacilityTableStats table;

    public FacilitiesStatsTab(TicsMain main) {
        this.main = main;
        contentPanel.setSizeFull();
        facilitiesSearchBox.setInputPrompt("Search for Facility");
        addListeners();
        table = new FacilityTableStats(main, facilities, this);
        headerBar.setSizeFull();
        headerBar.addComponent(facilitiesSearchBox);
        headerBar.setExpandRatio(facilitiesSearchBox, 1);
        headerBar.setComponentAlignment(facilitiesSearchBox, Alignment.MIDDLE_LEFT);

        headerBar.setComponentAlignment(facilitiesSearchBox, Alignment.MIDDLE_LEFT);

        facilitiesSearchBox.setWidth("650px");
        addComponent(headerBar);
        addComponent(new Label("<HR/>", ContentMode.HTML));
        contentPanel.removeAllComponents();
        contentPanel.addComponent(table);
        addComponent(contentPanel);


    }

    private void addListeners() {

        facilitiesSearchBox.addTextChangeListener(new FieldEvents.TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                table.removeAllItems();
                List<Facility> list = new ArrayList<>();
                for (Facility facility : facilities) {
                    if (facility.getFacilityName().toLowerCase().contains(event.getText().toLowerCase())) {
                        list.add(facility);
                    }
                }
                table = new FacilityTableStats(main, list, FacilitiesStatsTab.this);
                contentPanel.removeAllComponents();
                contentPanel.addComponent(table);
            }
        });

        facilitiesSearchBox.addShortcutListener(new ShortcutListener("Clear", ShortcutAction.KeyCode.ESCAPE, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                facilitiesSearchBox.setValue("");
                table = new FacilityTableStats(main, facilities, FacilitiesStatsTab.this);
                contentPanel.removeAllComponents();
                contentPanel.addComponent(table);
//
            }
        });
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        System.out.println("This is a TEst ");
    }
}
