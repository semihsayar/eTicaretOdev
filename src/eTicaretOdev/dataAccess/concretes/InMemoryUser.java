package eTicaretOdev.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaretOdev.dataAccess.abstracts.UserDao;
import eTicaretOdev.entities.concretes.User;

public class InMemoryUser implements UserDao {

	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println("User added: " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
		users.add(user);
	}

	@Override
	public void update(User user) {
		System.out.println("User updated: " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());

	}

	@Override
	public void delete(User user) {
		System.out.println("User deleted: " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
		users.remove(user);
	}

	@Override
	public User getEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		return this.users;
	}

}
