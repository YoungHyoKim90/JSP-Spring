package kr.or.ddit.login;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.login.service.AuthenticateServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/login/loginProcess")
public class LoginProcessServlet extends HttpServlet{
	private AuthenticateService service = new AuthenticateServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		* 1. 요청 접수(파라미터나 헤더와 관련된 데이터 확보->검증)
		req.setCharacterEncoding("UTF-8");
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		
		boolean saveFlag = Optional.ofNullable(req.getParameter("idSave"))
								.map(c->true)
								.orElse(false);
		
		
		boolean valid = StringUtils.isNotBlank(memId) &&
						StringUtils.isNotBlank(memPass);
		
//		* 3. model 을 공유 -> scope's setAttribute(name, value)
//		* 4. view layer 선택 : logical view Name
		HttpSession session = req.getSession(); 
		String viewName = null;
		
		if(!valid) {
//			resp.sendError(400, "아이디나 비번 누락.");
//			return;
			session.setAttribute("message", "아이디나 비번 누락");
			viewName = "redirect:/login/loginForm.jsp";
		}else {
//		* 2. Model information 생성
//		* 	 * data vs information vs content(view layer, MIME type)
			
			MemberVO inputData = new MemberVO();
			inputData.setMemId(memId);
			inputData.setMemPass(memPass);
			
			try {
			 	MemberVO authMember = service.authenticate(inputData);
			 	session.setAttribute("authMember", authMember);
				// redirect ?? 현재 요청에 대한 정보를 제거.
				viewName = "redirect:/";
//				Cookie : client side 저장 데이터
				Cookie idCookie = new Cookie("idCookie", memId);
				idCookie.setPath(req.getContextPath());
				if(saveFlag) {
					// create
					idCookie.setMaxAge(60*60*24*7);
				}else {
					// remove
					idCookie.setMaxAge(0);
				}
				resp.addCookie(idCookie);
			}catch (AuthenticateException e) {
				session.setAttribute("message", e.getMessage());
				viewName = "redirect:/login/loginForm.jsp";
			}
		}

//		* 5. view 로 이동 : forward [redirect]
		if(viewName.startsWith("redirect:")) {
			viewName = viewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + viewName);
		}else {
			req.getRequestDispatcher(viewName).forward(req, resp);
			
		}
		 
	}
}

















