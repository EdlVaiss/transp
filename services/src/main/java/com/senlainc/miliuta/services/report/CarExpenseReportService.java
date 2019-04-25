package com.senlainc.miliuta.services.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senlainc.miliuta.dao.report.CarExpenseReportDAO;
import com.senlainc.miliuta.model.report.ReportPrefsTransferObject;

@Service
public class CarExpenseReportService {
	@Autowired
	private CarExpenseReportDAO carExpenseReportDAO;

	public List<Object[]> getReport(ReportPrefsTransferObject prefs) {
		return carExpenseReportDAO.getReport(prefs);
	}
}
