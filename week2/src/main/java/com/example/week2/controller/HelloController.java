package com.example.week2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.week2.domain.Student;

@Controller
public class HelloController {
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

}