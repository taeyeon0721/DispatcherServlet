package test;

import org.springframework.stereotype.Component;

//@Component("gw")
public class GalaxyWatch implements Watch{
	
	public GalaxyWatch() {
		System.out.println("갤럭시워치 객체생성완료");
	}

	public void volumeUp() {//추상클래스로부터 메서드가 강제됨 오버라이딩됨
		System.out.println("갤럭시 소리 ++");
	};
	public void volumeDown() {
		System.out.println("갤럭시 소리 --");
	};
}
