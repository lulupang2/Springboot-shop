package springshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springshop.domain.Users;
import springshop.repository.MemoryUserRepository;
import springshop.repository.UserRepository;

@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Users join(Users users) {
		Optional<Users> result = userRepository.findByName(users.getUsername());
		result.ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});

		return userRepository.save(users);
	}

	public List<Users> findUsers() {
		return userRepository.findAll();
	}

	public Optional<Users> findOne(Long usernum) {
		return userRepository.findById(usernum);
	}

}
