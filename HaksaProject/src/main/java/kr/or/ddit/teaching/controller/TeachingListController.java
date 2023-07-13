package kr.or.ddit.teaching.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.teaching.service.TeachingService;
import kr.or.ddit.teaching.service.TeachingServiceImpl;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.TeachingVO;

@WebServlet("/teaching/teachingList.do")
public class TeachingListController extends HttpServlet {

	private TeachingService service = new TeachingServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		ProfessorVO authMember = (ProfessorVO) req.getSession().getAttribute("authMember");
		if (authMember == null) {
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		
		List<TeachingVO> teachingList = service.retrieveListByProCd(authMember.getProCd());
		req.setAttribute("teachingList", teachingList);

		String logicalViewName = "/teaching/teachingList";
		String viewName = "/" + logicalViewName + ".tiles";
		if (viewName.startsWith("redirect:")) {
			viewName = viewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + viewName);
		} else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}
