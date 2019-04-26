package com.senlainc.miliuta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senlainc.miliuta.model.report.ReportPrefsTransferObject;
import com.senlainc.miliuta.services.report.DriverExpenseReportService;

@RestController
@RequestMapping("/report/driverExpense")
public class DriverExpenseReportController {
	@Autowired
	private DriverExpenseReportService driverExpenseReportService;

	@PostMapping
	public List<Object[]> getReport(@RequestBody ReportPrefsTransferObject prefs) {
		return driverExpenseReportService.getReport(prefs);
	}
}
