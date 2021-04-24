package ru.job4j.pojo;

public class Library {
	public static void swap(Book[] books) {
		Book temp = books[0];
		books[0] = books[3];
		books[3] = temp;
	}

	public static void printBooks(Book[] books) {
		for (int i = 0; i < books.length; i++) {
			System.out.println(books[i].getName() + " " + books[i].getPages());
		}
	}

	public static void main(String[] args) {
		Book headFirst = new Book("Learn Java", 720);
		Book schildt = new Book("A beginner's guide", 801);
		Book martin = new Book("Clean code", 464);
		Book eckel = new Book("Thinking in Java", 1168);
		Book[] books = {headFirst, schildt, martin, eckel};
		printBooks(books);
		swap(books);
		System.out.println();
		printBooks(books);
		System.out.println();

		for (int i = 0; i < books.length; i++) {
			if (books[i].getName().equals("Clean code")) {
				System.out.println(books[i].getName() + " " + books[i].getPages());
			}
		}
	}
}
