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
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	private MemberService service = new MemberServiceImpl();
	
	/**
	 * 가입 양식 제공
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String logicalViewName = "member/memberForm";
		String viewName = "/" + logicalViewName + ".tiles";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}

	/**
	 * 양식을 통해 입력된 개인 정보 처리
	 *
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Front Controller Pattern 으로 중복 패턴 해결 필요함.
		req.setCharacterEncoding("UTF-8");
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
//		member.setMemId( req.getParameter("memId") );
		Map<String, String[]> parameterMap = req.getParameterMap();

		PopulateUtils.populate(member, parameterMap);

		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		ValidateUtils.validate(member, errors, InsertGroup.class);

		String viewName = null;
		String logicalViewName = null;
		
		if (errors.isEmpty()) {
			ServiceResult result = service.createMember(member);
			switch (result) {
				case PKDUPLICATE:
					req.setAttribute("message", "아이디 중복");
					logicalViewName = "member/memberForm";
					viewName = "/" + logicalViewName + ".tiles";
					break;
				case OK:
					viewName = "redirect:/";
					break;
				default:
					req.setAttribute("message", "서버 오류, 잠시 뒤 다시 시도하시오.");
					logicalViewName = "member/memberForm";
					viewName = "/" + logicalViewName + ".tiles";
					break;
			}
		}else {
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
