package kr.or.ddit.servlet03;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/05/serverTime")
public class ServerTimeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Refresh", "1"); // 동기 요청에 대해서만 동작하는 헤더
		ZoneId zone = ZoneId.systemDefault();
		LocalDate TODAY = LocalDate.now(zone);
		LocalDateTime CURRENT = LocalDateTime.now(zone);

		request.setAttribute("today", TODAY);
		request.setAttribute("current", CURRENT);
		
		String viewName="/jsonView.view";
		request.getRequestDispatcher(viewName).forward(request, response);
		

	}

}
