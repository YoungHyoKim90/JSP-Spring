package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.ProdVO;

@Controller
public class ProdInsertController{
	@Inject
	private ProdService service;
	@Inject
	private OthersDAO othersDAO;
	
	
	
	@GetMapping("/prod/prodInsert.do")
	public String getHandler(Model model){
		model.addAttribute("lprodList", othersDAO.selectLprodList());
		model.addAttribute("buyerList", othersDAO.selectBuyerList());
		model.addAttribute("prod", new ProdVO());
		
		return "prod/prodForm";
	}
	
	@PostMapping("/prod/prodInsert.do")
	public String postHandler(
			Model model
			,@Validated(InsertGroup.class) @ModelAttribute("prod") ProdVO prod // command object
			,Errors errors
			
			
			){
		
		model.addAttribute("lprodList", othersDAO.selectLprodList());
		model.addAttribute("buyerList", othersDAO.selectBuyerList());
		
//		ProdVO prod = new ProdVO();
//		req.setAttribute("prod", prod);
//		
//		PopulateUtils.populate(prodVO prod, req.getParameterMap());
//		Map<String, String> errors = new LinkedHashMap<>();
//		req.setAttribute("errors", errors);
//		ValidateUtils.validate(prod, errors, InsertGroup.class);
		//-> Handler 어댑트 쪽으로 너김
		
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.createProd(prod);
			if(ServiceResult.OK == result) {
				logicalViewName = "redirect:/prod/prodView.do?what="+prod.getProdId();
			}else {
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요.");
				logicalViewName = "prod/prodForm";
			}
		}else {
			logicalViewName = "prod/prodForm";
		}
		
		return logicalViewName;
	}
}

















