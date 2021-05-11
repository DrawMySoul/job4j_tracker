package ru.job4j.professions;

public class Builder extends Engineer {
	private String feature;

	public Builder(String name, String surname, String education,
	               String birthday, String organisation, String feature) {
		super(name, surname, education, birthday, organisation);
		this.feature = feature;
	}

	public void buildHouse(Design design) {
	}
}
