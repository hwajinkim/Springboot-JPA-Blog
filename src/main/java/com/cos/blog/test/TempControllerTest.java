package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	//localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// 파일리턴 기본경로 : src/main/resources/statid
		// 리턴명 : /home.html
		// 폴더 경로 : src/main/resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/a.png";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		// prefix :/WEB-INF/views
		// suffix :.jsp
		// 풀네임 : /WEB-INF/views/test.jsp
		return "test";
	}
}
