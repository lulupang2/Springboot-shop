package springshop.repository;

import java.util.List;
import java.util.Optional;

import springshop.domain.Users;

public interface UserRepository {
	Users save(Users users);
	Optional<Users> findById(Long usernum);
	Optional<Users> findByName(String username);
	List<Users> findAll();	
	

}
