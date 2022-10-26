package com.kim.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DataValidator implements Validator { //커맨드 객체

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {// 인자로 Object라는 최상위 클래스 있으면, 뭐가 들어올지모른다는 뜻
		// Object target: 사용자의 입력 값(커맨드객체)을 검증하기 위해, 파라미터로 받을 수 있게 구현한 부분
		//  -> 디자인 패턴을 활용한 예 : 부모에게 자식을 대입 가능
		DataDTO dto=(DataDTO)target;
		
		//커맨드 객체에 저장된 값을 추출
		String writer = dto.getWriter();
		if(writer==null || writer.trim().isEmpty()) { //★null 체크 순서 유의!!!
		//null은 서버공간을 할당을 못받은 것이고 , writer는 공백값: trim()-앞뒤다 잘랐는데도 비었니?
			System.out.println("로그: DataValidator: validate메서드: 작성자 null or empty");
			errors.rejectValue("writer", "error");
		}
		String content = dto.getContent();
		if(content==null || content.trim().isEmpty()) { //★null 체크 순서 유의!!!
		//null은 서버공간을 할당을 못받은 것이고 , writer는 공백값: trim()-앞뒤다 잘랐는데도 비었니?
			System.out.println("로그: DataValidator: validate메서드: 작성자 null or empty");
			errors.rejectValue("content", "error");
		}
		
	} 

	
}
