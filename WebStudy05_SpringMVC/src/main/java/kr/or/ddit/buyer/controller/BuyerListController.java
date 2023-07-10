package kr.or.ddit.buyer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.vo.BuyerVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BuyerListController {
	
	private final BuyerService service;
	
	@RequestMapping("/buyer/buyerList.do")
	public String getHandler(Model model){
		
		List<BuyerVO> buyerList = service.retrieveBuyerList();
		model.addAttribute("buyerList", buyerList);
		
		return "buyer/buyerList";
	}
}
