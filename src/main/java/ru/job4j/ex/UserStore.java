package ru.job4j.ex;

public class UserStore {
	public static User findUser(User[] users, String login) throws UserNotFoundException {
		User findUser = null;
		for (User user : users) {
			if (login.equals(user.getUsername())) {
				findUser = user;
				break;
			}
		}
		if (findUser == null) {
			throw new UserNotFoundException("UserNotFoundException");
		}
		return findUser;
	}

	public static boolean validate(User user) throws UserInvalidException {
		if (!user.isValid() || user.getUsername().length() < 3) {
			throw new UserInvalidException("UserInvalidException");
		}
		return true;
	}

	public static void main(String[] args) {
		User[] users = {
			new User("Petr Arsentev", true)
		};
		try {
			User user = findUser(users, "Petr Arsentev");
			if (validate(user)) {
				System.out.println("This user has an access");
			}
		} catch (UserInvalidException e) {
			System.out.println("User is not invalid");
		} catch (UserNotFoundException e) {
			System.out.println("User Not Found");
		}
	}
}
