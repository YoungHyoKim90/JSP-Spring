package kr.or.ddit.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberListController {
	private final MemberService service;
	
	@RequestMapping("/member/memberList.do")
	public String getHandler(Model model){
		List<MemberVO> memberList = service.retrieveMemberList();
		
		model.addAttribute("memberList", memberList);
		
		return "member/memberList";
	}
	
	@RequestMapping("/member/memberView.do")
	public String memberView(@RequestParam(name="who", required = true) String memId,Model model){
				
		MemberVO member = service.retrieveMember(memId);
		
		model.addAttribute("member", member);
		
		return "member/ajax/memberView";
	}
}












