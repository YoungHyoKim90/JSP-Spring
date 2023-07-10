package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.simple.AbstractController;
import kr.or.ddit.util.PopulateUtils;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.MemberVO;

public class MemberUpdateController extends AbstractController{
	
	private MemberService service = new MemberServiceImpl();
	
	@Override
	public String getHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO authMember = (MemberVO) req.getSession().getAttribute("authMember");
		MemberVO member = service.retrieveMember(authMember.getMemId());
		
		req.setAttribute("member", member);
		
		return "member/memberForm";
	}
	
	@Override
	public String postHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Front Controller Pattern 으로 중복 패턴 해결 필요함.
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

		String logicalViewName = null;
		
		if (errors.isEmpty()) {
			ServiceResult result = service.modifyMember(member);
			switch (result) {
				case INVALIDPASSWORD:
					req.setAttribute("message", "비밀번호 오류");
					logicalViewName = "member/memberForm";
					break;
				case OK:
					logicalViewName = "redirect:/mypage";
					break;
				default:
					req.setAttribute("message", "서버 오류, 잠시 뒤 다시 시도하시오.");
					logicalViewName = "member/memberForm";
					break;
			}
		}else {
			logicalViewName = "member/memberForm";
		}
		return logicalViewName;
	}
	
}
