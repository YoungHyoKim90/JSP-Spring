package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.simple.AbstractController;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

public class ProdListController extends AbstractController{
	private ProdService service = new ProdServiceImpl();
	@Override
	public String getHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProdVO> prodList = service.retrieveProdList();
		req.setAttribute("prodList", prodList);
		
		return "prod/prodList";
	}
}




















