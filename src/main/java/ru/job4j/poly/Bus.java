package ru.job4j.poly;

public class Bus implements Transport {
	@Override
	public void drive() {
		System.out.println(getClass().getSimpleName() + " едет");
	}

	@Override
	public void passengers(int passengers) {
		System.out.println(passengers + " пассажиров село в транспорт");
	}

	@Override
	public double gasStation(double fuel) {
		return fuel * 45.5;
	}
}
