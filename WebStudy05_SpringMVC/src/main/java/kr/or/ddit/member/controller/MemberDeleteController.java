package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.simple.AbstractController;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.vo.MemberVO;

public class MemberDeleteController extends AbstractController{
	private MemberService service = new MemberServiceImpl();
	
	@Override
	public String postHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String memPass = req.getParameter("password");
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		String memId = authMember.getMemId();
		MemberVO inputData = new MemberVO();
		inputData.setMemId(memId);
		inputData.setMemPass(memPass);
		Map<String, String> errors = new HashMap<>();
		ValidateUtils.validate(inputData, errors, DeleteGroup.class);
		
		String logicalViewName = null;
		if(errors.isEmpty()) {
			ServiceResult result = service.removeMember(inputData);
			switch (result) {
			case INVALIDPASSWORD:
				session.setAttribute("message", "비번 오류");
				logicalViewName = "redirect:/mypage";
				break;
			case OK:
				session.invalidate();
				logicalViewName = "redirect:/";
				break;
			default:
				break;
			}
		}else {
			session.setAttribute("message", "비번 누락");
			logicalViewName = "redirect:/mypage";
		}
		
		return logicalViewName;
	}
}

