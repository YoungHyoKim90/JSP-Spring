package kr.or.ddit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.service.FreeboardService;
import kr.or.ddit.board.vo.FreeboardVO;
import kr.or.ddit.board.vo.PaginationInfo;
import lombok.RequiredArgsConstructor; 

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardRetrieveController {
	
	private final FreeboardService service;
	
	@RequestMapping("boardList.do")
	public void boardList(
			@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
			, Model model
	) {
		PaginationInfo<FreeboardVO> paging = new PaginationInfo<>();
		paging.setCurrentPage(currentPage);
		
		List<FreeboardVO> boardList = service.retrieveBoardList(paging);
		paging.setDataList(boardList);
		
		model.addAttribute("paging", paging);
	}
	
	@RequestMapping("boardView.do")
	public void boardView() {
		
		
	}
}




















