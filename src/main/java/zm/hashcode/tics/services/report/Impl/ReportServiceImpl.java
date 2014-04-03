/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.services.report.Impl;

import com.google.gwt.thirdparty.guava.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.reports.Report;
import zm.hashcode.tics.repository.report.ReportRepository;
import zm.hashcode.tics.services.report.ReportService;

/**
 *
 * @author boniface
 */
@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report find(String id) {
        return reportRepository.findOne(id);
    }

    @Override
    public Report persist(Report entity) {
        return reportRepository.save(entity);
    }

    @Override
    public Report merge(Report entity) {
        System.out.println("DISTRICT "+entity.getDistrict()+ " SUBDISTRICT "+entity.getSubstrict()+" CITY "+entity.getCity()+" FACITITY"+entity.getFacility());
       return entity;
    }

    @Override
    public void remove(Report entity) {
        reportRepository.delete(entity);
    }

    @Override
    public List<Report> findAll() {
        return ImmutableList.copyOf(reportRepository.findAll());
    }
    
}
