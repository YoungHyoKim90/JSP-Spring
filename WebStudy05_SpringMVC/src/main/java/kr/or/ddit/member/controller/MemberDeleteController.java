package kr.or.ddit.member.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

@Controller
public class MemberDeleteController{
   @Inject
   MemberService service;
   
   @PostMapping("/member/memberDelete.do")
   public String postHandler(
      MemberVOWrapper principal
      , Optional<String> password 
      , RedirectAttributes redirectAttributes
      , HttpSession session
   ){
      String viewName = null;

      if (password.filter(p->!p.isEmpty()).isPresent()) {
         MemberVO inputData = new MemberVO();
         inputData.setMemId(principal.getName());
         inputData.setMemPass(password.get());
         ServiceResult result = service.removeMember(inputData);
         switch (result) {
         case INVALIDPASSWORD:
            redirectAttributes.addFlashAttribute("message", "비밀번호 오류");
            viewName = "redirect:/mypage";
            break;
         case OK:
            session.invalidate();
            viewName = "redirect:/";
            break;
         default:
//            session.setAttribute("message", "서버 오류, 잠시 뒤 다시 시도하시오.");
//            viewName = "redirect:/mypage";
            break;
         }
      } else {
         redirectAttributes.addFlashAttribute("message", "비밀번호 누락");
         viewName = "redirect:/mypage";
      }
   
      return viewName;

   }

}