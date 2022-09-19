package com.kim.biz.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	//input: 어떤 요청에 대해 == String
	//output: 무슨 Controller 객체를 제공해야하는지 == Controller 
	private Map<String, Controller> mappings; //의존관계 -> DI => 생성자 주입
	
	public HandlerMapping() {
		mappings = new HashMap<String,Controller>();
		mappings.put("/login.do", new LoginController());
		
		
		
		
		//key값이 들어오면, value를 반환(객체)
		//HM을 사용하므로써 싱글톤 패턴이 유지됨
	}
	
	public Controller getController(String command) {
		return mappings.get(command); //new LoginController()객체가 반환된 상태
	}
}

//		mappings.put("/main.do", new MainController());