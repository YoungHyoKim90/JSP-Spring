package kr.or.ddit.props.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.props.service.PropertyService;
import kr.or.ddit.props.service.PropertyServiceImpl;
import kr.or.ddit.vo.PropertyVO;

@WebServlet("/property")
public class PropertyControllerServlet extends HttpServlet {
	private PropertyService service = new PropertyServiceImpl();
	
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service.createProperty(null);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service.modifyProperty(null);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service.removeProperty(null);
	}
}
