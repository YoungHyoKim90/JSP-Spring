package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.util.PopulateUtils;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodInsert.do")
public class ProdInsertController extends HttpServlet{
	private ProdService service = new ProdServiceImpl();
	
	
//Front controller pattern
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String method = req.getMethod();
		
		String logicalViewName = null;
		
		if(method.equalsIgnoreCase("get")) {
			logicalViewName = getHandler(req, resp);
		}else if(method.equalsIgnoreCase("post")) {
			logicalViewName = postHandler(req, resp);
		}else {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, MessageFormat.format("{0} 메소드 요청은 지원되지 않습니다.", method));
			return;
		}
		
		
		if (logicalViewName.startsWith("redirect:")) {
			logicalViewName = logicalViewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + logicalViewName);
		} else {
			String viewName = "/"+logicalViewName+".tiles";
			req.getRequestDispatcher(viewName).forward(req, resp);

		}
	}
	
	protected String getHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "prod/prodForm";
	}
	
	protected String postHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProdVO prod = new ProdVO();
		req.setAttribute("prod", prod);
		
		PopulateUtils.populate(prod, req.getParameterMap());
		
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		
		ValidateUtils.validate(prod, errors, InsertGroup.class);
		
		String logicalViewName = null;
		if(errors.isEmpty()) {
			ServiceResult result = service.createProd(prod);
			if(ServiceResult.OK == result) {
				logicalViewName = "redirect:/prod/prodView.do?what="+prod.getProdId();
			}else {
				req.setAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요.");
				logicalViewName = "prod/prodForm";
			}
		}else {
			logicalViewName = "prod/prodForm";
		}
		
		return logicalViewName;
	}
}

















