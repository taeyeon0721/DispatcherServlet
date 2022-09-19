package com.kim.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //aspect는 포인트컷이랑 횡단관심의 결합이니까 여기에도 @붙여줘야함
public class PointcutCommon {
	@Pointcut("execution(* com.kim.biz..*Impl.*(..))")
	public void aPointcut(){}
	@Pointcut("execution(* com.kim.biz..*Impl.select*(..))")
	public void bPointcut(){}
}
