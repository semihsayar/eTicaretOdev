package eTicaretOdev.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaretOdev.business.abstracts.UserService;
import eTicaretOdev.core.abstracts.EmailService;
import eTicaretOdev.core.abstracts.RegisterService;
import eTicaretOdev.dataAccess.abstracts.UserDao;
import eTicaretOdev.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;
	private EmailService emailService;
	private RegisterService registerService;

	public UserManager(UserDao userDao, EmailService emailService, RegisterService registerService) {
		this.userDao = userDao;
		this.emailService = emailService;
		this.registerService = registerService;
	}

	@Override
	public void register(User user) {
		if (user.getPassword().length() < 6) {
			System.out.println("Password has to be at least 6 characters");
			return;
		}

		final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(user.getEmail());

		if (!matcher.matches()) {
			System.out.println("Unsupported Mail Format");
			return;
		}

		for (User users : userDao.getAll()) {
			if (users.getEmail() == user.getEmail()) {
				System.out.println("Email registered to the system");
				return;
			}
		}

		if (user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
			System.out.println("First and last name must be at least two characters.");
			return;
		}

		this.userDao.add(user);
		this.emailService.sendVerificationEmail();
		if (this.emailService.checkEmail()) {
			System.out.println("Verification Successful");
		} else {
			System.out.println("Verification Failed");
		}
	}

	@Override
	public void registerWithGoogle(User user) {

		if (registerService.register(user)) {
			System.out.println("Registration successful with google");
		} else {
			System.out.println("Failed to login with google");
		}
	}

	@Override
	public void delete(User user) {
		System.out.println("User deleted: " + user.getFirstName() + " " + user.getLastName());

	}

	@Override
	public void login(User user, String email, String password) {
		if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
			System.out.println("Login successful: " + user.getFirstName());
		} else {
			System.out.println("Password or Username is incorrect");
		}

	}

}
