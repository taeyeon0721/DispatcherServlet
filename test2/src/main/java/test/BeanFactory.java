package test;

public class BeanFactory {
	public Object getBean(String beanName) {//bean이라는 이름을 들으면 객체를 반환
		if(beanName.equals("galaxy")) {
			return new Galaxy();
		}
		else if(beanName.equals("iphone")) {
			return new IPhone();
		}
		return null;
	}
}
