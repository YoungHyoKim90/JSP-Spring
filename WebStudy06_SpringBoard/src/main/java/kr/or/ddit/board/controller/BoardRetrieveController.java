package kr.or.ddit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.service.FreeboardService;
import lombok.RequiredArgsConstructor; 

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardRetrieveController {
	private final FreeboardService service;
	
	@RequestMapping("boardList.do")
	public void boardList() {}
	@RequestMapping("boardView.do")
	public void boardView() {}
}
