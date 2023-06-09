package kr.or.ddit.buyer.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.vo.BuyerVO;

@Controller
public class BuyerViewController {

	@Inject
	BuyerService service;
	
	@RequestMapping("buyer/buyerView.do")
	public String getHandler(@RequestParam(name="what",required = true)String buyerId, Model model ){
		
		BuyerVO buyer = service.retrieveBuyer(buyerId);
		
		model.addAttribute("buyer",buyer);
		
		return "buyer/buyerView";
	}
}










