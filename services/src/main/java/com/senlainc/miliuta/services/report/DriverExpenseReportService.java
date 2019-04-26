package com.senlainc.miliuta.services.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senlainc.miliuta.dao.report.DriverExpenseReportDAO;
import com.senlainc.miliuta.model.report.ReportPrefsTransferObject;

@Service
public class DriverExpenseReportService {
	@Autowired
	private DriverExpenseReportDAO driverExpenseReportDAO;

	public List<Object[]> getReport(ReportPrefsTransferObject prefs) {
		return driverExpenseReportDAO.getReport(prefs);
	}
}
