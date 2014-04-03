/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.report;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.report.ReportService;

/**
 *
 * @author ColinWa
 */
public class ReportFacade {

    private final static SpringContext ctx = new SpringContext();

    public static ReportService getReportService() {
        return ctx.getBean(ReportService.class);
    }
}
