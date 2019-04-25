package com.senlainc.miliuta.model.report.valueholders;

public class IntValueHolder implements IValueHolder<Integer> {
	private Integer value;

	public IntValueHolder(Integer value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

}
