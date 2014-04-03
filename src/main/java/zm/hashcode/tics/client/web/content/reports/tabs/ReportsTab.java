/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.tabs;

import com.vaadin.addon.tableexport.ExcelExport;
import com.vaadin.data.Property;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.haijian.ExcelExporter;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.reports.ReportsMenu;
import zm.hashcode.tics.client.web.content.reports.tables.ReportTable;

/**
 *
 * @author boniface
 */
public class ReportsTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private ExcelExport excelExport;
    private static final String LANDING_TAB = "LANDING";
    private final TicsMain main;
    private final ReportTable table;
    private final Button backtoreports = new Button("Generate Another Report");
    private final Button excelExportButton = new Button("Export to Excel");

    public ReportsTab(TicsMain main, ReportTable table) {
        this.main = main;
        this.table = table;
        addListeners();
        backtoreports.setStyleName("default");
        addComponent(backtoreports);
        setComponentAlignment(backtoreports, Alignment.MIDDLE_RIGHT);
        addComponent(new Label("<HR/>", ContentMode.HTML));
        addComponent(table);
        addComponent(new Label("<HR/>", ContentMode.HTML));
        ExcelExporter excelExporter = new ExcelExporter(table);
        excelExporter.setCaption("Export to Excel");
        addComponent(excelExporter);
        setComponentAlignment(excelExporter, Alignment.MIDDLE_RIGHT);



    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == backtoreports) {
            main.content.setSecondComponent(new ReportsMenu(main, LANDING_TAB));
        }

        if (source == excelExportButton) {
            excelExport = new ExcelExport(table);
            excelExport.excludeCollapsedColumns();
            excelExport.setReportTitle("Demo Report");
            excelExport.export();
        }

    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
    }

    private void addListeners() {
        //Register Button Listeners
        backtoreports.addClickListener((Button.ClickListener) this);
        excelExportButton.addClickListener((Button.ClickListener) this);
        //Register Table Listerners
        table.addValueChangeListener((Property.ValueChangeListener) this);

    }
}
