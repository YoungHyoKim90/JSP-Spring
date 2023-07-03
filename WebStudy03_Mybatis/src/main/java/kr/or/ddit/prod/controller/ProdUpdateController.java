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

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.util.PopulateUtils;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodUpdate.do")
public class ProdUpdateController extends HttpServlet{
	private ProdService service = new ProdServiceImpl();
	private OthersDAO othersDAO = new OthersDAOImpl();
	
//	Front Controller pattern
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
		
		if(logicalViewName==null) {
			if(!resp.isCommitted())
				resp.sendError(500, "logical view name 이 결정되지 않았음.");
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
		req.setAttribute("lprodList", othersDAO.selectLprodList());
		req.setAttribute("buyerList", othersDAO.selectBuyerList());
		
		String prodId = req.getParameter("what");
		if(StringUtils.isBlank(prodId)) {
			resp.sendError(400, "필수 파라미터 누락");
			
			return null;
		}
		
		ProdVO prod = service.retrieveProd(prodId);
		req.setAttribute("prod", prod);
		
		return "prod/prodForm";
	}
	
	protected String postHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("lprodList", othersDAO.selectLprodList());
		req.setAttribute("buyerList", othersDAO.selectBuyerList());
		
		ProdVO prod = new ProdVO();
		req.setAttribute("prod", prod);
		
		PopulateUtils.populate(prod, req.getParameterMap());
		
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		
		ValidateUtils.validate(prod, errors, UpdateGroup.class);
		
		String logicalViewName = null;
		if(errors.isEmpty()) {
			ServiceResult result = service.modifyProd(prod);
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









