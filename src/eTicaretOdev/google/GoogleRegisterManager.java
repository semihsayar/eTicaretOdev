package eTicaretOdev.google;

import eTicaretOdev.entities.concretes.User;

public class GoogleRegisterManager {
	public void register(User user) {
		System.out.println(user.getFirstName() + " " + user.getEmail());
	}
}
