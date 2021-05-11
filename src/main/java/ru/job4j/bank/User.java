package ru.job4j.bank;

import java.util.Objects;

/**\
 * Класс хранит данные объектов типа User и предоставляет к ним доступ
 *  @author Michael Lobov
 *  @version 1.0
 */
public class User {
	/**
	 * Хранение паспорта объекта типа User в приватной переменной типа String
	 */
	private String passport;
	/**
	 * Хранение имени объекта типа User в приватной переменной типа String
	 */
	private String username;

	/**
	 * Конструктор класса который инициализирует поля passport и username
	 * @param passport значение поля passport переменной типа User
	 * @param username значение поля username переменной типа User
	 */
	public User(String passport, String username) {
		this.passport = passport;
		this.username = username;
	}

	/**
	 * Метод позволяет получить текущее значение поля passport
	 * @return текущее значение поля passport
	 */
	public String getPassport() {
		return passport;
	}

	/**
	 * Метод позволяющий установить новое значение для поля passport
	 * @param passport новое значение для поля passport
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}

	/**
	 * Метод позволяет получить текущее значение для поля username
	 * @return текущее значение для поля username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Метод позволяет установить новое значение для поля username
	 * @param username новое значение для поля username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Метод позволяющий сравнить два объекта на идентичность
	 * @param o объект с которым мы будем сравнивать
	 * @return результат проверки
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(passport, user.passport);
	}

	/**
	 * Метод позволяет сравнить hashCodе'ы объектов
	 * @return результат проверки
	 */
	@Override
	public int hashCode() {
		return Objects.hash(passport);
	}
}
