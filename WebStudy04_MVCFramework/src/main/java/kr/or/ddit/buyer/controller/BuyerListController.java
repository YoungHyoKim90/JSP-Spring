package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.mvc.simple.AbstractController;
import kr.or.ddit.vo.BuyerVO;

public class BuyerListController extends AbstractController{
	
	private BuyerService service = new BuyerServiceImpl();
	
	@Override
	public String getHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<BuyerVO> buyerList = service.retrieveBuyerList();
		req.setAttribute("buyerList", buyerList);
		
		return "buyer/buyerList";
	}
}
