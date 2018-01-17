package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/hello")
	public String hello(@RequestParam(name="location") String location, @RequestParam(name="name") String name) {
				return "Welcome to the " + location + ", " + name + "!";
	}
}