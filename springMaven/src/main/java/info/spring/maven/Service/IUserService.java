package info.spring.maven.Service;

import info.spring.maven.Model.Users;
import java.util.List;

public interface IUserService {
	public Users addUser(Users user);
	public List<Users> listUser() ;
	public void deleteUser(String id);
	public void updateUser(String id, String name, String surname, String telephone);
}
