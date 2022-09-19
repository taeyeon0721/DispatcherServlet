package test;

import org.springframework.stereotype.Component;

//@Component("aw")
public class AppleWatch implements Watch{
	
	public AppleWatch() {
		System.out.println("애플워치 객체생성완료");
	}//기본생성자로 로그찍음
	
	@Override
	public void volumeUp() {//오버라이딩됨
		System.out.println("애플워치 소리++");
	}
	@Override
	public void volumeDown() {
		System.out.println("애플워치 소리--");
	}

	
}
