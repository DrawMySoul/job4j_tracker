package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
	public static void main(String[] args) {
		System.out.println("Я великий Оракул. Что ты хочешь узнать?");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		int answer = new Random().nextInt(3);

		if (answer == 0) {
			System.out.println("Да");
		} else if (answer == 1) {
			System.out.println("Нет");
		} else if (answer == 2) {
			System.out.println("Может быть");
		}
	}
}
