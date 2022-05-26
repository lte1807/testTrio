package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	//http://localhost:8083/blog/tmp/home
	@GetMapping("/tmp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		return "/home.html";
	}
	
	@GetMapping("/tmp/jsp")
	public String tempJsp() {
		return "test";
	}
}
