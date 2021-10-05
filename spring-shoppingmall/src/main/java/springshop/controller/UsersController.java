package springshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import springshop.domain.Users;
import springshop.service.UserService;
@CrossOrigin(origins = "*", maxAge = 3600)

@Controller
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

//	
	@GetMapping("users/new")
	public String createUsers() {
		return "users/createUserForm";
	}

	@PostMapping("/users/new")
	public String create(joinForm form) {
		Users users = new Users();
		users.setUserid(form.getUserid());
		users.setUsername(form.getUsername());
		users.setUserpasswd(form.getUserpasswd());
		users.setUseremail(form.getUseremail());
		users.setAddr1(form.getAddr1());
		users.setAddr2(form.getAddr2());
		users.setAddr3(form.getAddr3());

		userService.join(users);

		return "redirect:/";
	}

	@GetMapping("/users")
	public String list(Model model) {
		List<Users> users = userService.findUsers();
		model.addAttribute("users", users);
		return "users/userslist";
	}	

}
