package eTicaretOdev.dataAccess.abstracts;

import java.util.List;

import eTicaretOdev.entities.concretes.User;

public interface UserDao {

	void add(User user);

	void update(User user);

	void delete(User user);

	User getEmail(String email);

	List<User> getAll();
}
