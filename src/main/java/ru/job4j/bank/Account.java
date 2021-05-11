package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс хранит данные и предоставляет к ним доступ
 * @author Michael Lobov
 * @version 1.0
 */
public class Account {
	/**
	 * Хранение реквизитов осуществляется в приватной переменной типа String
	 */
	private String requisite;
	/**
	 * Хранение суммы на балансе осуществляется в приватной переменной типа double
	 */
	private double balance;

	/**
	 * Конструктор класса который инициализирует переменные requisite и balance
	 * @param requisite реквизиты которыми инициализируется объект типа Account
	 * @param balance баланс которыми инициализируется объект типа Account
	 */
	public Account(String requisite, double balance) {
		this.requisite = requisite;
		this.balance = balance;
	}

	/**
	 * Метод для получения реквизитов
	 * @return возвращает реквизиты
	 */
	public String getRequisite() {
		return requisite;
	}

	/**
	 * Метод позволяет установить новое значение для поля requisite
	 * @param requisite новое значение для поля requisite
	 */
	public void setRequisite(String requisite) {
		this.requisite = requisite;
	}

	/**
	 * Метод позволяет получить текущее значение для поля balance
	 * @return текущее значение поля balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Метод позволяет установить новое значение для поля balance
	 * @param balance новое значение для поля balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
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
		Account account = (Account) o;
		return Objects.equals(requisite, account.requisite);
	}

	/**
	 * Метод позволяет сравнить hashCodе'ы объектов
	 * @return результат проверки
	 */
	@Override
	public int hashCode() {
		return Objects.hash(requisite);
	}
}
