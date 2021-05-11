package ru.job4j.pojo;

import java.util.Date;

public class College {
	public static void main(String[] args) {
		Student student = new Student();
		student.setFio("Лобов Михаил Николаевич");
		student.setGroupNumber(123);
		student.setCrated(new Date());

		System.out.println(student.getFio() + " "
			+ student.getGroupNumber() + " " + student.getCrated());
	}
}
