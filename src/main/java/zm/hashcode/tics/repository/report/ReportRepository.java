/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.repository.report;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.reports.Report;

/**
 *
 * @author boniface
 */

public interface ReportRepository extends PagingAndSortingRepository<Report, String> {
    
}
