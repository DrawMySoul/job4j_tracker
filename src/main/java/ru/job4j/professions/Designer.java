package ru.job4j.professions;

public class Designer extends Engineer {
	private char feature;

	public Designer(String name, String surname, String education,
	                String birthday, String organisation, char feature) {
		super(name, surname, education, birthday, organisation);
		this.feature = feature;
	}

	public Design makeDesign() {
		return new Design();
	}
}
