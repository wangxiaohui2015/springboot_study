package com.my.study.properties.module;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomVal {
	@Value("${com.test.value}")
	private String strVa;
	@Value("${com.test.number}")
	private int intVal;
	@Value("${com.test.bignumber}")
	private long longVal;
	@Value("${com.test.random1}")
	private int ranIntVal;
	@Value("${com.test.random2}")
	private int ranIntVal2;

	public String getStrVa() {
		return strVa;
	}

	public void setStrVa(String strVa) {
		this.strVa = strVa;
	}

	public int getIntVal() {
		return intVal;
	}

	public void setIntVal(int intVal) {
		this.intVal = intVal;
	}

	public long getLongVal() {
		return longVal;
	}

	public void setLongVal(long longVal) {
		this.longVal = longVal;
	}

	public int getRanIntVal() {
		return ranIntVal;
	}

	public void setRanIntVal(int ranIntVal) {
		this.ranIntVal = ranIntVal;
	}

	public int getRanIntVal2() {
		return ranIntVal2;
	}

	public void setRanIntVal2(int ranIntVal2) {
		this.ranIntVal2 = ranIntVal2;
	}
}
