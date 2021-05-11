package ru.job4j.professions;

public class ResuscitationDoctor extends Doctor {
	private double feature;

	public ResuscitationDoctor(String name, String surname, String education,
	                           String birthday, int hospitalNumber, double feature) {
		super(name, surname, education, birthday, hospitalNumber);
		this.feature = feature;
	}

	public double getFeature() {
		return feature;
	}

	public void saveLife(Pacient pacient) {
	}
}
