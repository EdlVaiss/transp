package com.senlainc.miliuta.model.report;

import java.io.Serializable;

public class WherePref implements Serializable {

	private static final long serialVersionUID = 3064106794291656852L;

	private String path;
	private Operator operator;
	private Object param;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}
}
