package com.kim.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//around로 사용할 advice는 반드시 pjp를 input(인자로)으로 가져야한다
//비즈니스로직을 사이에 두고 전후로 자기가 영향력을 행사할 수 있음
// ex) 필터(에서 요청정보를 가로채서) 서블릿 클래스
@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointcutCommon.bPointcut()")
	public Object printLogAround(ProceedingJoinPoint pjp) throws Throwable {
		
		String methodName = pjp.getSignature().getName();
		System.out.println("수행중인 핵심메서드명: "+methodName);

		StopWatch sw = new StopWatch();
		sw.start();
		Object returnObj = pjp.proceed();
		//pjp.proceed()에 의해 비즈니스메서드가 수행됨!
		sw.stop();
		System.out.println("수행시간: "+sw.getTotalTimeMillis()+"ms");
		
		return returnObj;
	}
}
