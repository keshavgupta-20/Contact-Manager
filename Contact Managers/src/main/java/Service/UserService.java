package Service;

import Entites.User;

public interface UserService {
	User Login(String gmail, String Password);
	boolean Register(String name, String email, String Password, String rePassword);
}
