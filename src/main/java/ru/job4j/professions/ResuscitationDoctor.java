package ru.job4j.professions;

public class ResuscitationDoctor extends Doctor {
	public ResuscitationDoctor(String name, String surname, String education, String birthday, int hospitalNumber) {
		super(name, surname, education, birthday, hospitalNumber);
	}

	public void saveLife(Pacient pacient) {
	}
}
