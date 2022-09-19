package com.kim.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.biz.common.LogAdvice;
import com.kim.biz.member.MemberService;
import com.kim.biz.member.MemberVO;

//@Component를 상속받는 어노테이션
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired // 타입으로만 찾기 때문에 MemberDAO 타입의 객체가 메모리에 있어야지만 DI(의존성 주입)이 가능
	private MemberDAO2 memberDAO; //watch를 멤버변수로 둠 //controller역할 //M.s와 M.d의 중간다리역할

	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.updateMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.deleteMember(vo);
	}

	@Override
	   public MemberVO selectOneMember(MemberVO vo) {
	      if(vo.getMid().equals("timo")) {
	         throw new IllegalArgumentException("[실행시예외]");
	      }
	      return memberDAO.selectOneMember(vo);
	   }

	@Override
	public List<MemberVO> selectAllMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.selectAllMember(vo);
	}
	
	

	


}
