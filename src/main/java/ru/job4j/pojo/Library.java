package ru.job4j.pojo;

public class Library {
	public static void main(String[] args) {
		Book headFirst = new Book("Learn Java", 720);
		Book schildt = new Book("A beginner's guide", 801);
		Book martin = new Book("Clean code", 464);
		Book eckel = new Book("Thinking in Java", 1168);
		Book[] books = {headFirst, schildt, martin, eckel};

		for (Book book : books) {
			System.out.println(book.getName() + " " + book.getPages());
		}
		Book temp = books[0];
		books[0] = books[3];
		books[3] = temp;
		System.out.println();

		for (Book book : books) {
			System.out.println(book.getName() + " " + book.getPages());
		}
		System.out.println();

		for (Book book : books) {
			if ("Clean code".equals(book.getName())) {
				System.out.println(book.getName() + " " + book.getPages());
			}
		}
	}
}
