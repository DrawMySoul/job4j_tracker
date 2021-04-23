package ru.job4j.oop;

public class Error {
	private boolean active;
	private int status;
	private String message;

	public Error() {
	}

	public Error(boolean active, int status, String message) {
		this.active = active;
		this.status = status;
		this.message = message;
	}

	public void printInfo() {
		System.out.println("Is active - " + active);
		System.out.println("Status is " + status);
		System.out.println("Message : " + message);
	}

	public static void main(String[] args) {
		Error error = new Error();
		Error errorIsActive = new Error(true, 1, "This error is of high priority.");
		Error errorIsNotActive = new Error(false, 5, "You can drink tea.");
		error.printInfo();
		System.out.println();
		errorIsActive.printInfo();
		System.out.println();
		errorIsNotActive.printInfo();
	}
}
