package kr.or.ddit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.service.FreeboardService;
import kr.or.ddit.board.vo.FreeboardVO;
import kr.or.ddit.board.vo.PaginationInfo;
import kr.or.ddit.board.vo.SimpleCondition;
import lombok.RequiredArgsConstructor; 

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardRetrieveController {
	
	private final FreeboardService service;
	
	@RequestMapping("boardList.do")
	public void boardList(
			@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
			, @ModelAttribute("simpleCondition") SimpleCondition simpleCondition
			, Model model
	) {
		PaginationInfo<FreeboardVO> paging = new PaginationInfo<>();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		List<FreeboardVO> boardList = service.retrieveBoardList(paging);
		paging.setDataList(boardList);
		
		model.addAttribute("paging", paging);
	}
	
	@RequestMapping("boardView.do")
	public void boardView(
		@RequestParam("what") int boNo
		, Model model
	) {
		FreeboardVO board = service.retrieveBoard(boNo);
		model.addAttribute("freeboard", board);
	}
//	의존성주입의 종류로는 Constructor(생성자),Setter,Field 타입이 있다.
//	@RequestParam 어노테이션은 사용자가 요청시 전달하는 값을 Handler(Controller)의 
//	매개변수로 1:1 맵핑할때 사용되는 어노테이션입니다.
//	@ModelAttribute는 사용자가 요청시 전달하는 값을 오브젝트 형태로 매핑해주는 어노테이션입니다.	
}




















