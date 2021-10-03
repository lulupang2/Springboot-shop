package springshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class shopController {
	@GetMapping("/")
	public String home() {
		return "home";
	}

}
