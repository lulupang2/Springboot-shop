package springshop.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import springshop.domain.Users;

public class MemoryUserRepository implements UserRepository{
	
	private static Map<String, Users> store = new HashMap<>();
	private static Long sequence = 0L;

	@Override
	public Users save(Users users) {
		// TODO Auto-generated method stub
		users.setUsernum(++sequence);
		return users;
	}

	@Override
	public Optional<Users> findById(Long usernum) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(store.get(usernum));
	}

	@Override
	public Optional<Users> findByName(String username) {
		// TODO Auto-generated method stub
		return store.values().stream()
		.filter(users -> users.getUsername().equals(username)).findAny();
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		
		return new ArrayList<>(store.values());
	}
	

}
