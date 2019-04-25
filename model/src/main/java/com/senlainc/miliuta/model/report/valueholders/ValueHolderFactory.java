package com.senlainc.miliuta.model.report.valueholders;

public class ValueHolderFactory {
	private String value;

	public ValueHolderFactory(String value) {
		this.value = value;
	}

	public IValueHolder<?> getValueHolder() {
		if (isInteger(value)) {
			return new IntValueHolder(Integer.parseInt(value));
		} else if (isDouble(value)) {
			return new DoubleValueHolder(Double.parseDouble(value));
		} else {
			return new StringValueHolder(value);
		}
	}

	private boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
