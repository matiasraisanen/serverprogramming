package com.example.week2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.week2.domain.Friend;
import com.example.week2.domain.Student;

@Controller
public class HelloController {
	List<Friend> friendlist = new ArrayList<>();
	
	@RequestMapping("/hello")
	public String students(Model model) {
		Student student1 = new Student("Kate", "Cole", "kate@cole.com");
		Student student2 = new Student("Dan", "Brown", "dan@brown.com");
		Student student3 = new Student("Mike", "Mars", "mike@mars.com");

		List<Student> list = new ArrayList<>();
		list.add(student1);
		list.add(student2);
		list.add(student3);

		model.addAttribute("students", list);
		
		return "hello";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String friends(@RequestParam(value="name") String name, Model model) {
		Friend friend0 = new Friend(null);
		friendlist.add(new Friend(name));
		model.addAttribute("friend", friend0);
		model.addAttribute("friends", friendlist);
		return "index";
	}

}