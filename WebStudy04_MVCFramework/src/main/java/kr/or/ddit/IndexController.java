package kr.or.ddit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.simple.AbstractController;

public class IndexController extends AbstractController{
	@Override
	public String getHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("welcomeMessage", "웰컴 페이지용 안내 메시지");
		
		return "index";
	}
}
