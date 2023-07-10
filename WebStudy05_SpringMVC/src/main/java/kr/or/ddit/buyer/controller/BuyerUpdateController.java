package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.mvc.simple.AbstractController;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.util.PopulateUtils;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.BuyerVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BuyerUpdateController {
	private BuyerService service;
	private OthersDAO othersDAO;
	
	@RequestMapping("/buyer/buyerUpdate.do")
	public String getHandler(Model model){
		model.addAttribute("lprodList", othersDAO.selectLprodList());
		
		String buyerId = req.getParameter("what");
		if(StringUtils.isBlank(buyerId)) {
			resp.sendError(400, "필수 파라미터 누락");
			
			return null;
		}
		
		BuyerVO buyer = service.retrieveBuyer(buyerId);
		req.setAttribute("buyer", buyer);
		
		return "buyer/buyerForm";
	}
	
	@RequestMapping
	public String postHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("lprodList", othersDAO.selectLprodList());
		
		BuyerVO buyer = new BuyerVO();
		req.setAttribute("buyer", buyer);
		
		PopulateUtils.populate(buyer, req.getParameterMap());
		
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		
		ValidateUtils.validate(buyer, errors, UpdateGroup.class);
		
		String logicalViewName = null;
		if(errors.isEmpty()) {
			ServiceResult result = service.modifyBuyer(buyer);
			if(ServiceResult.OK == result) {
				logicalViewName = "redirect:/buyer/buyerView.do?what="+buyer.getBuyerId();
			}else {
				req.setAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요.");
				logicalViewName = "buyer/buyerForm";
			}
		}else {
			logicalViewName = "buyer/buyerForm";
		}
		
		return logicalViewName;
	}
	
}









