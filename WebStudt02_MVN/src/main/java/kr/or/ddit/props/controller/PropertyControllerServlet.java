package kr.or.ddit.props.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.props.service.PropertyService;
import kr.or.ddit.props.service.PropertyServiceImpl;
import kr.or.ddit.vo.PropertyVO;

@WebServlet("/property")
public class PropertyControllerServlet extends HttpServlet {
	private PropertyService service = new PropertyServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accept = req.getHeader("accept");
		
		String viewName = null;
		if(accept.contains("json")) {
			List<PropertyVO> propList = service.retrieveProperties();
			req.setAttribute("propList", propList);
			viewName = "/jsonView.view";
		}else {
			String logicalViewName = "props/singleViewCase2";
			viewName = "/"+logicalViewName+".tiles";
		}
		
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
	private boolean validate(PropertyVO propVO) {
		boolean valid = true;
		return valid;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PropertyVO propVO = null;
		try(
			InputStream is = req.getInputStream();
		){
			propVO = new ObjectMapper().readValue(is, PropertyVO.class);
		}
		
		if(validate(propVO)) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		}
		
		// call by reference
		boolean success = service.createProperty(propVO);
		
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("prop", propVO);
		resultMap.put("success", success);
		req.setAttribute("result", resultMap);
		String viewName = null;
		if(success) {
			viewName = "redirect:/property";
		}else {
			viewName = "/jsonView.view";
		}
		
		if(viewName.startsWith("redirect:")) {
			viewName = viewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + viewName);
		}else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service.modifyProperty(null);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> resultMap = new HashMap<>();
		String propertyName = null;
		try(
			InputStream is = req.getInputStream();
		){
		 	PropertyVO prop = new ObjectMapper().readValue(is, PropertyVO.class);
		 	propertyName = prop.getPropertyName();
		 	resultMap.put("prop", prop);
		}
		
//		String propertyName = req.getParameter("propertyName");
		
		if(StringUtils.isBlank(propertyName)) {
			resp.sendError(400, "필수파라미터 누락");
			return;
		}
		
		boolean success = service.removeProperty(propertyName);
		
		resultMap.put("success", success);
		req.setAttribute("result", resultMap);
		String viewName = null;
		
//		if(success) {
//			viewName = "redirect:/property"; // delete
//		}else {
			viewName = "/jsonView.view";
//		}
		
		if(viewName.startsWith("redirect:")) {
			viewName = viewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + viewName);
		}else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}















