package ru.job4j.bank;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

	@Test
	public void addUser() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		Optional<User> result = Optional.of(new User("3434", "Petr Arsentev"));
		assertThat(bank.findByPassport("3434"), is(result));
	}

	@Test
	public void whenEnterInvalidPassport() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("5546", 150D));
		assertNull(bank.findByRequisite("34", "5546"));

	}

	@Test
	public void addAccount() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("5546", 150D));
		assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
	}

	@Test
	public void transferMoney() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("5546", 150D));
		bank.addAccount(user.getPassport(), new Account("113", 50D));
		bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
		assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
	}
}