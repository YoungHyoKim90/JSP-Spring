package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteController extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		String memPass = req.getParameter("password");
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		String memId = authMember.getMemId();
		MemberVO inputData = new MemberVO();
		inputData.setMemId(memId);
		inputData.setMemPass(memPass);
		Map<String, String> errors = new HashMap<>();
		ValidateUtils.validate(inputData, errors, DeleteGroup.class);
		
		String viewName = null;
		if(errors.isEmpty()) {
			ServiceResult result = service.removeMember(inputData);
			switch (result) {
			case INVALIDPASSWORD:
				session.setAttribute("message", "비번 오류");
				viewName = "redirect:/mypage";
				break;
			case OK:
				session.invalidate();
				viewName = "redirect:/";
				break;
			default:
				break;
			}
		}else {
			session.setAttribute("message", "비번 누락");
			viewName = "redirect:/mypage";
		}
		
		
		if (viewName.startsWith("redirect:")) {
			viewName = viewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + viewName);
		} else {
			req.getRequestDispatcher(viewName).forward(req, resp);

		}
	}
}

