package kr.or.ddit.login;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.validate.groups.loginGroup;
import kr.or.ddit.vo.ProfessorVO;

@Controller
public class LoginProcessController  {
	
	@Inject
	private AuthenticateService service;
	
	@Inject
	private WebApplicationContext context;
	
	private ServletContext application;

	@PostConstruct
	public void init() {
		application = context.getServletContext();
	}
	
	@RequestMapping("/login/loginProcess")
	public String doPost(
				@RequestParam(required = false) Optional<String> idSave
				, @Validated(loginGroup.class) ProfessorVO inputData
				, Errors errors 
				, HttpSession session
		        , HttpServletResponse resp
		        , HttpServletRequest req
			) {
		boolean saveFlag = idSave.map(c -> true).orElse(false);
		
		boolean valid = !errors.hasErrors();
		
		String viewName = null;
		
		if (!valid) {
			session.setAttribute("message", "코드누락");
			viewName = "redirect:/login/loginForm.jsp";
		} else {
			
			try {
				ProfessorVO authMember = service.authenticate(inputData);
				session.setAttribute("authMember", authMember);
				viewName = "redirect:/";
//				Cookie : client side 저장 데이터
				Cookie idCookie = new Cookie("idCookie", authMember.getProDept());
				idCookie.setPath(application.getContextPath());
				if (saveFlag) {
					idCookie.setMaxAge(60*60*24*7);
				} else {
					idCookie.setMaxAge(0);
				}
				resp.addCookie(idCookie);
			} catch (AuthenticateException e) {
				session.setAttribute("message", e.getMessage());
				viewName = "redirect:/login/loginForm.jsp";
			}
		}

		return viewName;
	}
}
