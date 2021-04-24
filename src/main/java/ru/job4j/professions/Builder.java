package ru.job4j.professions;

public class Builder extends Engineer {
	public Builder(String name, String surname, String education, String birthday, String organisation) {
		super(name, surname, education, birthday, organisation);
	}

	public void buildHouse(Design design) {
	}
}
