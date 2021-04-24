package ru.job4j.pojo;

import java.util.Date;

public class Student {
	private String fio;
	private int groupNumber;
	private Date crated;

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public Date getCrated() {
		return crated;
	}

	public void setCrated(Date crated) {
		this.crated = crated;
	}
}
