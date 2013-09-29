/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.home.tabs;

import com.google.common.collect.Collections2;
import com.vaadin.ui.VerticalLayout;
import java.util.Collection;
import java.util.List;
import org.dussan.vaadin.dcharts.DCharts;
import org.dussan.vaadin.dcharts.base.elements.PointLabels;
import org.dussan.vaadin.dcharts.base.elements.XYaxis;
import org.dussan.vaadin.dcharts.data.DataSeries;
import org.dussan.vaadin.dcharts.data.Ticks;
import org.dussan.vaadin.dcharts.metadata.TooltipAxes;
import org.dussan.vaadin.dcharts.metadata.locations.PointLabelLocations;
import org.dussan.vaadin.dcharts.metadata.locations.TooltipLocations;
import org.dussan.vaadin.dcharts.metadata.renderers.AxisRenderers;
import org.dussan.vaadin.dcharts.metadata.renderers.SeriesRenderers;
import org.dussan.vaadin.dcharts.options.Axes;
import org.dussan.vaadin.dcharts.options.Highlighter;
import org.dussan.vaadin.dcharts.options.Legend;
import org.dussan.vaadin.dcharts.options.Options;
import org.dussan.vaadin.dcharts.options.SeriesDefaults;
import org.dussan.vaadin.dcharts.renderers.series.PieRenderer;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.services.people.predicates.FemalePredicate;
import zm.hashcode.tics.services.people.predicates.MalePredicate;

/**
 *
 * @author boniface
 */
public class PeopleStatsTab extends VerticalLayout {

    private final TicsMain main;

    public PeopleStatsTab(TicsMain main) {
        this.main = main;
        List<Person> participants = PersonFacade.getPeople();
        Collection<Person> males = Collections2.filter(participants, new MalePredicate());
        Collection<Person> females = Collections2.filter(participants, new FemalePredicate());

        DataSeries dataSeries = new DataSeries()
                .add(participants.size(), females.size(), males.size());

        SeriesDefaults seriesDefaults = new SeriesDefaults()
                .setPointLabels(new PointLabels()
                .setShow(true)
                .setLocation(PointLabelLocations.EAST)
                .setEdgeTolerance(-15))
                .setRenderer(SeriesRenderers.BAR);


        Axes axes = new Axes()
                .addAxis(
                new XYaxis()
                .setRenderer(AxisRenderers.CATEGORY)
                .setTicks(
                new Ticks()
                .add("TOTAL", "FEMALES", "MALES")));

        Highlighter highlighter = new Highlighter()
                .setShow(true)
                .setShowTooltip(true)
                .setTooltipAlwaysVisible(true)
                .setKeepTooltipInsideChart(true)
                .setTooltipLocation(TooltipLocations.NORTH)
                .setTooltipAxes(TooltipAxes.XY_BAR);

        Options options = new Options()
                .setSeriesDefaults(seriesDefaults)
                .setAxes(axes)
                .setHighlighter(highlighter);

        DCharts chart = new DCharts()
                .setDataSeries(dataSeries)
                .setOptions(options)
                .show();
        addComponent(chart);

        //==============================

        DataSeries dataChat = new DataSeries()
                .newSeries()
                .add("MALES", males.size())
                .add("FEMALES", females.size());

        SeriesDefaults seriesChat = new SeriesDefaults()
                .setRenderer(SeriesRenderers.PIE)
                .setRendererOptions(
                new PieRenderer()
                .setFill(false)
                .setShowDataLabels(true)
                .setSliceMargin(4)
                .setLineWidth(5));

        Legend legend = new Legend()
                .setShow(true);

        Options chartOptions = new Options()
                .setSeriesDefaults(seriesChat)
                .setLegend(legend);

        DCharts dChart = new DCharts()
                .setDataSeries(dataChat)
                .setOptions(chartOptions)
                .show();
//        addComponent(dChart);
    }
}
