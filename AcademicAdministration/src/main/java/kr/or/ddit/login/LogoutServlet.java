package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청접수
		// 2. 로그아웃 처리
		// 	  'authId'라는 세션의 속성이 없어져야 함 => 세션 자체가 없어지고 새로운 세션이 생기는게 맞음.
		HttpSession session = req.getSession(false);
		if (session != null && !session.isNew()) {
//			session.removeAttribute("authId");
			session.invalidate();
		}
		resp.sendRedirect(req.getContextPath() + "/");
	}
}
