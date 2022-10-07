package com.kim.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.kim.biz.board.BoardService;
import com.kim.biz.board.BoardVO;

@Controller
@SessionAttributes("data") //"data"라는 이름의 데이터가 Model 객체에 세팅이 된다면, 
// 그것을 session에 기억시키겠다
public class BoardController {

	@Autowired
	private BoardService boardService; //비즈니스 컴포넌트 -> DAO직접 사용 xx 


	@ModelAttribute("scMap") //@requestMapping보다 빨리 호출됨
	public Map<String,String> searchConditionMap(){// <key,value>
		Map<String,String> scMap = new HashMap<String,String>();
		scMap.put("제목", "TITLE"); //key값: VIEW에 어떻게 보여야하는지
		scMap.put("작성자", "WRITER"); //value값: MODEL에서 어떻게 쓰여야하는지
		scMap.put("내용", "CONTENT"); 
		return scMap;
		//모델에 자동 저장됨 == Model.addAttribute();
	}

	@RequestMapping("/main.do")
	public String selectAllBoard(BoardVO bVO, Model model) {

		if(bVO.getSearchCondition() == null) {
			bVO.setSearchCondition("");
		}
		if(bVO.getSearchContent() == null) {
			bVO.setSearchContent("");
		}

		System.out.println("검색조건: "+bVO.getSearchCondition());
		System.out.println("검색어: "+bVO.getSearchContent());



		List<BoardVO> datas=boardService.selectAllBoard(bVO);

		model.addAttribute("datas",datas);
		System.out.println("메인로그");
		return "main.jsp";
	}


	@RequestMapping("/bupdate.do")
	public String updateBoard(@ModelAttribute("data")BoardVO bVO) {

		System.out.println("update로그: "+bVO);
		
		MultipartFile uploadFile=bVO.getUploadFile();
		if(!uploadFile.isEmpty()) { // 업로드한 파일 존재여부 확인
			String fileName=uploadFile.getOriginalFilename(); // 업로드한 파일명
			bVO.setImg(fileName);//db에 저장할 파일명
			try {
				uploadFile.transferTo(new File("C:\\java_kty\\workspace2\\Attributes\\src\\main\\webapp\\images\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 업로드한 파일을 지정한 경로에 저장
		}
		
		boardService.updateBoard(bVO);
		
		System.out.println("확ㅇ니");

//		if(bVO==null) {
//			return "board.jsp";
//		}
//		else {
			return "redirect:main.do";
			//forward: 요청정보를 다음페이지로 유지(url유지)
			//redirect: 새 요청(url바뀜)
		
	}



	@RequestMapping("/board.do")
	// 자동매핑 안되는 경우?
	//command객체의 멤버변수로 SearchCondition이나 Content가 없기때문에
	// VO에 자바에서만 쓰는 멤버변수로 추가 -> 가장 이상적
	public String selectOneBoard(BoardVO bVO, Model model) {

		bVO=boardService.selectOneBoard(bVO);

		model.addAttribute("data", bVO);
		return "board.jsp";
	}

	@RequestMapping("/binsert.do")
	public String insertBoard(BoardVO bVO) throws IllegalStateException, IOException {
		System.out.println("insertb로그: "+bVO);
		
		//bVO.setImg("2nd.png");
		MultipartFile uploadFile=bVO.getUploadFile();
		if(!uploadFile.isEmpty()) { // 업로드한 파일 존재여부 확인
			String fileName=uploadFile.getOriginalFilename(); // 업로드한 파일명
			bVO.setImg(fileName);//db에 저장할 파일명
			uploadFile.transferTo(new File("C:\\java_kty\\workspace2\\Attributes\\src\\main\\webapp\\images\\"+fileName)); // 업로드한 파일을 지정한 경로에 저장
		}
		boardService.insertBoard(bVO);
		System.out.println("로그:"+bVO);

		return "redirect:main.do";
	}


	@RequestMapping("/bdelete.do")
	public String deleteBoard(BoardVO bVO) {

		System.out.println("delete로그: "+bVO);
		//sessionAttributes 로그
		boardService.deleteBoard(bVO);

		if(bVO==null) {
			return "board.jsp";
		}
		else {
			return "redirect:main.do";
			//forward: 요청정보를 다음페이지로 유지(url유지)
			//redirect: 새 요청(url바뀜)
		}
	}




	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO bVO=new BoardVO();
		bVO.setBid(Integer.parseInt(request.getParameter("bid")));

		BoardDAO bDAO=new BoardDAO();
		bVO=bDAO.selectOneBoard(bVO);

		HttpSession session=request.getSession();
		session.setAttribute("data", bVO);

		return "board";
	}
	 */

}
