package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класса описывающий работу сервиса банка
 * @author Michael Lobov
 * @version 1.0
 */
public class BankService {
	/**
	 * Пользователи и их счета хранятся в коллекции типа HashMap
	 * Ключ это объект типа User это ключ
	 * Значение это коллекция типа ArrayList, где хранятся счета
	 */
	private Map<User, List<Account>> users = new HashMap<>();

	/**
	 * Метод позволяющий добавить пользователя и коллекцию счетов
	 * Если такого пользователя еше нет
	 * @param user пользователь который добавляется в коллекцию users
	 */
	public void addUser(User user) {
		users.putIfAbsent(user, new ArrayList<>());
	}

	/**
	 * Метод позволяющий добавить новый счет пользователю
	 * Если есть пользователь с определенным паспортом
	 * @param passport паспорт для поиска пользователя
	 * @param account новый счет для добавления
	 */
	public void addAccount(String passport, Account account) {
		User user = findByPassport(passport);
		if (user != null && !users.get(user).contains(account)) {
			users.get(user).add(account);
		}
	}

	/**
	 * Метод позволяет найти пользователя по паспорту
	 * @param passport паспорт для поиска пользователя
	 * @return возвращает найденного пользователя или null если пользователя не найден
	 */
	public User findByPassport(String passport) {
		User foundUser = null;
		for (User user : users.keySet()) {
			if (user.getPassport().equals(passport)) {
				foundUser = user;
				break;
			}
		}
		return foundUser;
	}

	/**
	 * Метод позволяет найти счет у пользователя по паспорту
	 * @param passport паспорт для поиска пользователя
	 * @param requisite реквизиты для поиска счета
	 * @return возвращает счет или null если пользователь или счет не найдены
	 */
	public Account findByRequisite(String passport, String requisite) {
		User user = findByPassport(passport);
		Account foundAccount = null;
		if (user != null) {
			for (Account account : users.get(user)) {
				if (account.getRequisite().equals(requisite)) {
					foundAccount = account;
					break;
				}
			}
		}
		return foundAccount;
	}

	/**
	 * Метод позволяет перевести сумму с одного счета на другой
	 * @param srcPassport паспорт для поиска пользователя с чего счета переводить деньги
	 * @param srcRequisite реквизиты для поиска счета с которого переводить
	 * @param destPassport паспорт для поиска пользователя на чей счет переводить
	 * @param destRequisite реквизиты для поиска на какой счет переводить
	 * @param amount сумма перевода
	 * @return возвращает true если перевод прошел успешно
	 * Возвращает false 1) если какой либо из пользователей или счетов не был найден
	 * Возвращает false 2) если денег на счете srcRequisite не достаточно
	 */
	public boolean transferMoney(String srcPassport, String srcRequisite,
	                             String destPassport, String destRequisite, double amount) {
		boolean rsl = false;
		Account account = findByRequisite(srcPassport, srcRequisite);
		if (account != null && account.getBalance() >= amount) {
			Account transferAccount = findByRequisite(destPassport, destRequisite);
			if (transferAccount != null) {
				account.setBalance(account.getBalance() - amount);
				transferAccount.setBalance(transferAccount.getBalance() + amount);
			}
			rsl = true;
		}
		return rsl;
	}
}
