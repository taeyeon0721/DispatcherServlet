package test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("gphone")
public class Galaxy implements Phone {

	@Autowired
//	@Qualifier("gw")
	private Watch watch;
	private int number;
	public Galaxy() {
		System.out.println("갤럭시 객체생성완료");
	}
	
	public Galaxy(Watch watch,int number) {
		this.watch=watch;
		this.number=number;
	}
	@Override
	public void powerOn() {
		System.out.println("갤럭시 전원 ON");
	}
	@Override
	public void powerOff() {
		System.out.println("갤럭시 전원 OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("갤럭시 소리 ++");
	}
	@Override
	public void volumeDown() {
		System.out.println("갤럭시 소리 --");
	}
	
	/*
	public void initMethod() {
		System.out.println("객체를 초기화하는 작업을 처리하는 메서드...");
	}
	public void destroyMethod() {
		System.out.println("객체 메모리를 해제할때 호출하는 메서드...");
	}
	*/
	
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
