package Dao;

import Entites.User;

public interface UserDao {
	public User getUserByEmailAndPassword(String email, String password);
	public boolean saveUser(User user);
}
