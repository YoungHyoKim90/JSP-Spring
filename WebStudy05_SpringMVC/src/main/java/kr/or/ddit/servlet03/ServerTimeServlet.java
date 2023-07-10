package kr.or.ddit.servlet03;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/05/serverTime")
public class ServerTimeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Refresh", "1"); // 동기 요청에 대해서만 동작하는 헤더.
		ZoneId zone = Optional.ofNullable(request.getParameter("zone"))
//				sugar syntax : 문법이 허용하는 범위내에서 간결하게 코드를 작성하는 방식.
								.map(zp->ZoneId.of(zp))
								.orElse(ZoneId.systemDefault());
				
		Locale locale = Optional.ofNullable(request.getParameter("locale"))
								.map(lp->Locale.forLanguageTag(lp))
								.orElse(request.getLocale());
		
		LocalDate TODAY = LocalDate.now(zone);
		LocalDateTime CURRENT = LocalDateTime.now(zone);
		
		request.setAttribute("today", TODAY);
		request.setAttribute("current", CURRENT);
		request.setAttribute("zone", zone.getDisplayName(TextStyle.FULL, locale));
		
		String viewName = "/jsonView.view";
		request.getRequestDispatcher(viewName).forward(request, response);
	}
}




















