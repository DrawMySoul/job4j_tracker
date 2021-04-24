package ru.job4j.professions;

public class Engineer extends Profession {
	private String organisation;

	public Engineer(String name, String surname, String education, String birthday, String organisation) {
		super(name, surname, education, birthday);
		this.organisation = organisation;
	}

	public void repair(Object object) {
	}
}
