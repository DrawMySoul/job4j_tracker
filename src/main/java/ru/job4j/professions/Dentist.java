package ru.job4j.professions;

public class Dentist extends Doctor {
	private int feature;

	public Dentist(String name, String surname, String education,
	               String birthday, int hospitalNumber, int feature) {
		super(name, surname, education, birthday, hospitalNumber);
		this.feature = feature;
	}

	public void healTooth(Pacient pacient) {
	}

	public void healTeeth(Pacient pacient) {
	}
}
