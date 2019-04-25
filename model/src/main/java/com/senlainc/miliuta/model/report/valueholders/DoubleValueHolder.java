package com.senlainc.miliuta.model.report.valueholders;

public class DoubleValueHolder implements IValueHolder<Double> {
	private Double value;

	public DoubleValueHolder(Double value) {
		this.value = value;
	}

	@Override
	public Double getValue() {
		return value;
	}

}
