package ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import DaoImple.UserdaoImpl;
import Entites.User;
import Service.UserService;
import jakarta.servlet.RequestDispatcher;

public class UserServiceImpl implements UserService {
	private final UserdaoImpl userDao = new UserdaoImpl();
	

	@Override
	public boolean Register( String name, String email, String Password, String rePassword) {
		User user = new User();
		String userId = UUID.randomUUID().toString();
	        user.setUserId(userId);
	        user.setName(name);
	        user.setEmail(email);
	        user.setPassword(Password);
	        return userDao.saveUser(user);	
	}

	@Override
	public User Login(String gmail, String Password) {
		User user2 =  userDao.getUserByEmailAndPassword(gmail, Password);
		return user2;
	}
}
