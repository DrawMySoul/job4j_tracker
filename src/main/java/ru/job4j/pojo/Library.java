package ru.job4j.pojo;

public class Library {
	public static void main(String[] args) {
		Book headFirst = new Book("Learn Java", 720);
		Book schildt = new Book("A beginner's guide", 801);
		Book martin = new Book("Clean code", 464);
		Book eckel = new Book("Thinking in Java", 1168);
		Book[] books = {headFirst, schildt, martin, eckel};

		for (int i = 0; i < books.length; i++) {
			System.out.println(books[i].getName() + " " + books[i].getPages());
		}
		Book temp = books[0];
		books[0] = books[3];
		books[3] = temp;
		System.out.println();

		for (int i = 0; i < books.length; i++) {
			System.out.println(books[i].getName() + " " + books[i].getPages());
		}
		System.out.println();

		for (int i = 0; i < books.length; i++) {
			if ("Clean code".equals(books[i].getName())) {
				System.out.println(books[i].getName() + " " + books[i].getPages());
			}
		}
	}
}
