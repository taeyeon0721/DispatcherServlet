package test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kim.biz.board.BoardService;
import com.kim.biz.board.BoardVO;
import com.kim.biz.member.MemberService;
import com.kim.biz.member.MemberVO;

public class Client {
	public static void main(String[] args) {

		//Spring 컨테이너를 동작시킬수 있도록 코드작성
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		//	System.out.println("로그");
		/*	xml파일을 참조하면서부터 실행은 xml에서 시작 -> xml 파일에 모든 객체가 만들어지고 
	TestBean tb=(TestBean)factory.getBean("tb"); // 그 객체중에 이걸 참조하라는 뜻
	Map<String,String> datas = tb.getDatas();
	System.out.println(datas);
	factory.close();
		 */	
/*
		//Spring 컨테이너야, 나 폰 객체를 갖고싶음!
		// ==LOOK UP == 객체요청: 컨테이너야, 가지고 있는 객체 중에 이름이 "phone"인 객체를 줘
		Phone phone = (Phone) factory.getBean("iphone");
			phone.powerOn();
			phone.volumeUp();
			phone.volumeDown();
			phone.powerOff();
			factory.close();
*/
/*			
		BoardService bs=(BoardService)factory.getBean("boardService");

		BoardVO vo=new BoardVO();
		Scanner sc=new Scanner(System.in);
		System.out.print("내용작성 >> ");
		String msg=sc.nextLine();
		vo.setContent(msg);
		vo.setTitle("글 제목");
		vo.setWriter("티모");
		bs.insertBoard(vo);
			
		List<BoardVO> datas=bs.selectAllBoard(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		factory.close();
*/
			
		MemberService ms = (MemberService) factory.getBean("memberService");
		// factory.getBean("memberService") -> 얘는 객체를 찾는 요청일뿐(Lookup), 여기서 객체 생성하는게 아님
		Scanner sc = new Scanner(System.in);
/*		System.out.println("회원가입 페이지");
        
        System.out.print("아이디 >> ");
        String mid = sc.nextLine();
        System.out.print("비밀번호 >>");
        String mpw = sc.nextLine();   
        System.out.print("이름 >>");
        String mname = sc.nextLine();   
        
        MemberVO mvo = new MemberVO();
        mvo.setMid(mid);
        mvo.setMpw(mpw);
        mvo.setName(mname);
        mvo.setRole("Member");
        
        ms.insertMember(mvo); //crud 핵심로직
*/               
		System.out.println("로그인하기");
		System.out.print("아이디: ");
		String mid2 = sc.next();
		System.out.print("비번: ");
		String mpw2 = sc.next();

		MemberVO vo = new MemberVO();
		vo.setMid(mid2);
		vo.setMpw(mpw2);
		vo = ms.selectOneMember(vo); //핵심로직을 수행하려고한다!
		if(vo != null) {
			System.out.println(vo.getName()+"님 안녕하세요!");
		}
		else {
			System.out.println("로그인 실패");
		}

		factory.close();




		/*	
	BeanFactory bf = new BeanFactory();//BeanFactory를 new하는 것 말고는 new행위가 사라짐
	Phone phone = (Phone)bf.getBean("iphone"); //인자로 galaxy가 들어가면 그에 맞는 객체 반환 
	phone.powerOn();
	phone.volumeUp();
	phone.volumeDown();
	phone.powerOff();
		 */
	}
}
//run configuration - arguments - program arguments(프로그램돌릴때 필요한 인자 넣을 수 있음)