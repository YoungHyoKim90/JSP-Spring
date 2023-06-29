package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.util.PopulateUtils;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {

	private MemberService service = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO authMember = (MemberVO) req.getSession().getAttribute("authMember");
		MemberVO member = service.retrieveMember(authMember.getMemId());

		req.setAttribute("member", member);

		String logicalViewName = "member/memberForm";
		String viewName = "/" + logicalViewName + ".tiles";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Front Controller Pattern 으로 중복 패턴 해결 필요함.
		req.setCharacterEncoding("UTF-8");

		MemberVO authMember = (MemberVO) req.getSession().getAttribute("authMember");

		MemberVO member = new MemberVO();
		member.setMemId(authMember.getMemId());
		req.setAttribute("member", member);
//		member.setMemId( req.getParameter("memId") );
		Map<String, String[]> parameterMap = req.getParameterMap();

		PopulateUtils.populate(member, parameterMap);

		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		ValidateUtils.validate(member, errors, UpdateGroup.class); // 상황에 따라 검증 조건이 달라짐.

		String viewName = null;
		String logicalViewName = null;

		if (errors.isEmpty()) {
			ServiceResult result = service.modifyMember(member);
			switch (result) {
			case INVALIDPASSWORD:
				req.setAttribute("message", "비밀번호 오류");
				logicalViewName = "member/memberForm";
				viewName = "/" + logicalViewName + ".tiles";
				break;
			case OK:
				viewName = "redirect:/mypage";
				break;
			default:
				req.setAttribute("message", "서버 오류, 잠시 뒤 다시 시도하시오.");
				logicalViewName = "member/memberForm";
				viewName = "/" + logicalViewName + ".tiles";
				break;
			}
		} else {
			logicalViewName = "member/memberForm";
			viewName = "/" + logicalViewName + ".tiles";
		}

		if (viewName.startsWith("redirect:")) {
			viewName = viewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + viewName);
		} else {
			req.getRequestDispatcher(viewName).forward(req, resp);

		}
	}

}
