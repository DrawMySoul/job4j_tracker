package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
	private Map<User, List<Account>> users = new HashMap<>();

	public void addUser(User user) {
		users.putIfAbsent(user, new ArrayList<>());
	}

	public void addAccount(String passport, Account account) {
		User user = findByPassport(passport);
		if (user != null && !users.get(user).contains(account)) {
			users.get(user).add(account);
		}
	}

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
