package com.kim.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Validator 실습";
	}
	
	@RequestMapping("/insertPage")
	public String insertPage() {
		return "insertPage";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute("dto")DataDTO dto, BindingResult result) {
							//ModelAttribute를 붙여서 "dto" 데이터 유지
		
		String viewName="boardPage"; //상세페이지로 가야하는데
		System.out.println("로그: TestController: insert메서드: dto: "+dto);
		DataValidator validator = new DataValidator(); //유효성 검사 객체 만듦
		validator.validate(dto, result); //result는 참조변수 ★
		
		if(result.hasErrors()) { //에러가 발견되었다면
			viewName = "insertPage"; //원래대로 insertPage로
		}
		
		return "boardPage";
	}
	
	
}
