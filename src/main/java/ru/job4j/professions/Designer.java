package ru.job4j.professions;

public class Designer extends Engineer {
	public Designer(String name, String surname, String education, String birthday, String organisation) {
		super(name, surname, education, birthday, organisation);
	}

	public Design makeDesign() {
		return new Design();
	}
}
