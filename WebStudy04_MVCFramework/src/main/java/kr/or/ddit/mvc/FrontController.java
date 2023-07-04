package kr.or.ddit.mvc;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.simple.AbstractController;
import kr.or.ddit.mvc.simple.AbstractControllerHandlerAdapter;
import kr.or.ddit.mvc.simple.AbstractControllerHandlerMapping;
import kr.or.ddit.mvc.simple.HandlerAdapter;
import kr.or.ddit.mvc.simple.HandlerMapping;

public class FrontController extends HttpServlet{
	private HandlerMapping handlerMapping;
	private HandlerAdapter handlerAdapter;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String location = config.getInitParameter("configLocation");
		handlerMapping = new AbstractControllerHandlerMapping(location);
		handlerAdapter = new AbstractControllerHandlerAdapter();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String logicalViewName = null;
		
		AbstractController controller = handlerMapping.findCommandHandler(req);
		
		if(controller==null) {
			resp.sendError(404, MessageFormat.format("{0} 서비스는 제공되지 않습니다.", req.getRequestURI()));
			return;
		}
		
		logicalViewName = handlerAdapter.invokeHandler(controller, req, resp);
		
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
}
