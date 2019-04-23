package com.senlainc.miliuta.model.report;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ReportPrefsTransferObject implements Serializable {

	private static final long serialVersionUID = -7582698471397182912L;

	private List<String> selectPrefs;
	private List<WherePref> wherePrefs;
	LocalDate laterThanDate;
	LocalDate earlierThanDate;

	public List<String> getSelectPrefs() {
		return selectPrefs;
	}

	public void setSelectPrefs(List<String> selectPrefs) {
		this.selectPrefs = selectPrefs;
	}

	public List<WherePref> getWherePrefs() {
		return wherePrefs;
	}

	public void setWherePrefs(List<WherePref> wherePrefs) {
		this.wherePrefs = wherePrefs;
	}

	public LocalDate getLaterThanDate() {
		return laterThanDate;
	}

	public void setLaterThanDate(LocalDate laterThanDate) {
		this.laterThanDate = laterThanDate;
	}

	public LocalDate getEarlierThanDate() {
		return earlierThanDate;
	}

	public void setEarlierThanDate(LocalDate earlierThanDate) {
		this.earlierThanDate = earlierThanDate;
	}
}
