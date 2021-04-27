package ru.job4j.oop;

public class Plane implements Vehicle {
	@Override
	public void move() {
		System.out.println(getClass().getSimpleName() + " летит по воздуху");
	}

	@Override
	public void stop() {
		System.out.println(getClass().getSimpleName() + " приземлился в аэропорту");
	}

	public static void main(String[] args) {
		Vehicle bus = new Bus();
		Vehicle train = new Train();
		Vehicle plane = new Plane();

		Vehicle[] transports = {bus, train, plane};
		for (Vehicle transport : transports) {
			transport.move();
			transport.stop();
			System.out.println();
		}
	}
}
