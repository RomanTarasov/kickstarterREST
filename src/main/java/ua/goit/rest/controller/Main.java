package ua.goit.rest.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Main {
	@RequestMapping(value = {"/","/main"}, method = RequestMethod.GET)
	public String doGet(Model model) {
		return "main";
	}
}
