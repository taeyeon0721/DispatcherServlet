package com.kim.biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice("com.kim.biz") //CommonExceptionHandler를 객체화해주는 어노테이션
								// => 이 메서드를 쓰려면 ceh.xxx라고 써야하니까 객체화 시켜줘야하고 그걸 @가 해준단 소리

public class CommonExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView aException(Exception e) { //널포인터 익셉션
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/error/error.jsp");
		return mav;
		//전달할 정보 있어서 반환값 mav로 설정 (어디로 어떤값 보낼지)
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView bException(Exception e) { //수학적인 문제
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/error/error.jsp");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView cException(Exception e) { //미확인 예외
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/error/error.jsp");
		return mav;	
	}
}
		
		