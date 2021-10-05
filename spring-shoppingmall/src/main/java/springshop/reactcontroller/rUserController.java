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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class rUserController {
	private UserService userService;

	@Autowired
	public rUserController(@RequestBody UserService userService) {
		this.userService = userService;
	}

	@GetMapping // get 요청
	public List<Users> users() {
		return userService.findUsers(); // 모든 유저 출력
	}

	@PostMapping("/new")
	public long create(joinForm form) {
		Users users = new Users();
		users.setUserid(form.getUserid());
		users.setUsername(form.getUsername());
		users.setUserpasswd(form.getUserpasswd());
		users.setUseremail(form.getUseremail());
		users.setAddr1(form.getAddr1());
		users.setAddr2(form.getAddr2());
		users.setAddr3(form.getAddr3());
		return userService.join(users);
	}
}
