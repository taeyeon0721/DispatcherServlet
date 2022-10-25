package com.kim.springboot.test;

import org.springframework.stereotype.Component;

@Component("memberA")
public class MemberA implements Member{

	@Override
	public void hello(String msg) {
		System.out.println("A멤버: "+msg);
	}

}
