package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {
	@RequestMapping("/index")
	public String helloMain() {
		return "This is the main page";
	}
	
	@RequestMapping("/contact")
	public String helloContact() {
		return "This is the contact page";
	}
}