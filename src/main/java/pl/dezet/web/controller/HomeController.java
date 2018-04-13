package pl.dezet.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.dezet.model.Transit;
import pl.dezet.model.User;

import javax.validation.Valid;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}



	
}