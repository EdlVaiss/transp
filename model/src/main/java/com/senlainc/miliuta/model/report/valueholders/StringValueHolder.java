package com.senlainc.miliuta.model.report.valueholders;

public class StringValueHolder implements IValueHolder<String> {
	private String value;

	public StringValueHolder(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

}
