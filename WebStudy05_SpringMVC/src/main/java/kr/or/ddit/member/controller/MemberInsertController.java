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
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;

public class MemberInsertController extends AbstractController{
	private MemberService service = new MemberServiceImpl();
	
	/**
	 * 가입 양식 제공
	 */
	@Override
	public String getHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "member/memberForm";
	}

	/**
	 * 양식을 통해 입력된 개인 정보 처리
	 *
	 */
	@Override
	public String postHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Front Controller Pattern 으로 중복 패턴 해결 필요함.
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
//		member.setMemId( req.getParameter("memId") );
		Map<String, String[]> parameterMap = req.getParameterMap();

		PopulateUtils.populate(member, parameterMap);

		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		ValidateUtils.validate(member, errors, InsertGroup.class);

		String logicalViewName = null;
		
		if (errors.isEmpty()) {
			ServiceResult result = service.createMember(member);
			switch (result) {
				case PKDUPLICATE:
					req.setAttribute("message", "아이디 중복");
					logicalViewName = "member/memberForm";
					break;
				case OK:
					logicalViewName = "redirect:/";
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
