package kr.co.yhk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T01FirstServlet extends HttpServlet {
// servlet 의 생명주기를 보기 위해 만든 FirstServlet class 이다.
	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 메서드 호출");
	}

	@Override
	public void destroy() {
		System.out.println("destory 메서드 호출");
	}

}
