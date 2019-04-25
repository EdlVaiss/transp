package com.senlainc.miliuta.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senlainc.miliuta.model.report.Operator;
import com.senlainc.miliuta.model.report.ReportPrefsTransferObject;
import com.senlainc.miliuta.model.report.WherePref;
import com.senlainc.miliuta.services.report.CarExpenseReportService;

@RestController
@RequestMapping("/report/carExpense")
public class CarExpenseReportController {
	@Autowired
	private CarExpenseReportService carExpenseReportService;

	@PostMapping
	public List<Object[]> getReport(@RequestBody ReportPrefsTransferObject prefs) {
		return carExpenseReportService.getReport(prefs);
	}

	// TODO method for test purposes only
	@GetMapping
	public ReportPrefsTransferObject getPrefs() {
		ReportPrefsTransferObject prefs = new ReportPrefsTransferObject();

		WherePref wp = new WherePref();
		wp.setPath("cost");
		wp.setOperator(Operator.gt);
		wp.setParam("19");

		WherePref wp1 = new WherePref();
		wp1.setPath("mileage");
		wp1.setOperator(Operator.gt);
		wp1.setParam("199000");
		prefs.setSelectPrefs(Arrays.asList("id", "car.brand", "mileage", "remark"));
		prefs.setWherePrefs(Arrays.asList(wp, wp1));

		return prefs;
	}
}
