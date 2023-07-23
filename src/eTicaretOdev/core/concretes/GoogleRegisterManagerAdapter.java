package eTicaretOdev.core.concretes;

import eTicaretOdev.core.abstracts.RegisterService;
import eTicaretOdev.entities.concretes.User;
import eTicaretOdev.google.GoogleRegisterManager;

public class GoogleRegisterManagerAdapter implements RegisterService {
	
	@Override
	public boolean register(User user) {
		GoogleRegisterManager googleRegisterManager = new GoogleRegisterManager();
		googleRegisterManager.register(user);
		return true;
	}

}
