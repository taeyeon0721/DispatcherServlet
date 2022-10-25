package com.kim.springboot.test;

import org.springframework.stereotype.Component;

@Component("memberB")
public class MemberB implements Member{

	@Override
	public void hello(String msg) {
		System.out.println("B멤버: "+msg);

		
		
		
		
	}

}
