package com.kim.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test02Application {

	public static void main(String[] args) {
		SpringApplication.run(Test02Application.class, args); //내장된 톰캣 실행
	//1. main메서드 실행
	//2. @SpringBootApplication의 영향으로 @ 스캔 및 등록
	//3. 10번라인에 의해 내장 톰켓 실행
	//4. ApplicationContext 생성 == 스프링 컨테이너 실행
	//		-> URL로 요청시 RequestMapping에 의해 작성한 메서드가 호출되는 방식
	
	
	}

}
