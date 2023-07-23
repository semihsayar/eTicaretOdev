package eTicaretOdev.core.concretes;

import eTicaretOdev.core.abstracts.EmailService;

public class EmailManager implements EmailService {

	@Override
	public void sendVerificationEmail() {
		System.out.println("Verification email sent");

	}

	@Override
	public boolean checkEmail() {
			return true;

	}

}
