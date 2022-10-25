package com.kim.springboot.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	/*
	@Autowired
	Leader leader1;
	@Autowired
	Leader leader2;
	@Autowired
	@Qualifier("memberB")
	Member member;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		leader1.hello();
		leader1.setMember(member);
		leader1.hello();
		
		
		return "루트(표지) 페이지"; //원래여기 .jsp나 .do 요청 와야하는데 
								//문자열 그대로 출력하고 싶으면 R사용
	}
	*/
	
	/*
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "JSP를 SpringBoot에서 이용해보자!";
	}
	@RequestMapping("/index")
	public String index() {
		return "index"; //실제로 호출되는 페이지의 경로는 /WEB-INF/view/index.jsp이다!
	}
	@RequestMapping("/test")
	public String test() {
		return "sub/test";
	}
	*/
	
	@RequestMapping("/")
	public @ResponseBody String root() {		
		return "커맨드 객체 사용하는 예제: 사용자로부터 데이터를 받아올 예정";
	}
	@RequestMapping("/test1")
	public String test1(HttpServletRequest req,Model model) {
		model.addAttribute("id",req.getParameter("id"));
		
		String name=req.getParameter("name"); // 코드 가독성 증가
		model.addAttribute("name",name);
		
		return "test1";
	}
	@RequestMapping("/test2")
	public String test2(@RequestParam("id")String id,@RequestParam("name")String name,Model model) {
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		
		return "test2";
	}
	@RequestMapping("/test3")
	public String test3(Student student,Model model) {
		return "test3";
	}
	// 4. 경로에 변수를 추가하는 방식
	@RequestMapping("/test4/{studentId}/{studentName}")
	public String test4(@PathVariable String studentId, @PathVariable String studentName, Model model) {
		model.addAttribute("id",studentId);
		model.addAttribute("name",studentName);
		
		return "test4";
	}
}
