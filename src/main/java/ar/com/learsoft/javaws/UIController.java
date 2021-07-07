package ar.com.learsoft.javaws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
public class UIController {

	@GetMapping("/index")
	public String rover() {
		return "index";
	}
}
