package springshop.reactcontroller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springshop.controller.joinForm;
import springshop.domain.Users;
import springshop.repository.JpaUserRepository;
import springshop.repository.UserRepository;
import springshop.service.UserService;

@CrossOrigin(origins = "*") // 크로스도메인 CORS 설정
@RestController // JSON 형태로 객체 반환
public class rUserController {
	private final UserService userService;

	@Autowired
	public rUserController(@RequestBody UserService userService) {
		this.userService = userService;
	}
	@GetMapping("/api/users") // get 요청
	public List<Users> users() {
		return userService.findUsers(); // 모든 유저 출력
	}

	@PostMapping("/api/users/new")
	public Users createUsers(@RequestBody Users users) {
		return userService.join(users);
	}
}
