package com.kim.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service //객체화 -> Impl랑 엮이기 때문에 service류
@Aspect  //둘 결합완료 의미
public class LogAdvice {

	@Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {
		         		//JoinPoint: 현재수행중인 포인트컷
		String methodName = jp.getSignature().getName();
		//현재 수행중인 포인트컷(핵심로직, CRUD)의 메서드명
		Object[] args = jp.getArgs();
		//현재 수행중인 포인트컷(핵심로직, CRUD)이 사용하는 인자들의 정보
		
		System.out.println("수행중인 핵심메서드명: "+methodName);
		System.out.println("사용하는 인자");
		System.out.println("----------");
		
		for(Object v:args) {
			System.out.println(v);
		} //v는 Object를 의미하니까 바로 콘솔에 출력불가 -> toString해줘야함
		  //MemberVO에서 toString을 오버라이딩했고 해당클래스가 동적바인딩 되어 주소값으로 나오지않음 
	}
}
