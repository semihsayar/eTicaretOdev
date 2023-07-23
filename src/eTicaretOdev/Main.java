package eTicaretOdev;

import eTicaretOdev.business.abstracts.UserService;
import eTicaretOdev.business.concretes.UserManager;
import eTicaretOdev.core.concretes.EmailManager;
import eTicaretOdev.core.concretes.GoogleRegisterManagerAdapter;
import eTicaretOdev.dataAccess.concretes.InMemoryUser;
import eTicaretOdev.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		UserService userService = new UserManager(new InMemoryUser(), new EmailManager(),
				new GoogleRegisterManagerAdapter());

		User user1 = new User(1, "Semih", "Sayar", "sayars244@gmail.com", "123456");
		userService.register(user1);
		System.out.println();
		userService.registerWithGoogle(user1);
		System.out.println();
		userService.login(user1, "sayars244@gmail.com", "123456");

	}
}
