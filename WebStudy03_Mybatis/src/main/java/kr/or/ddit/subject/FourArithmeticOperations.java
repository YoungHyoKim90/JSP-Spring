package kr.or.ddit.subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/operations.do")
public class FourArithmeticOperations extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		double firstNum = Double.parseDouble(request.getParameter("firstNum"));
		String operation = request.getParameter("operation");
		double secondNum = Double.parseDouble(request.getParameter("secondNum"));

		double result = 0;

		switch (operation) {
		case "add":
			result = firstNum + secondNum;
			break;
		case "subtract":
			result = firstNum - secondNum;
			break;
		case "multiply":
			result = firstNum * secondNum;
			break;
		case "divide":
			if (secondNum == 0) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Cannot divide by zero!");
				return;
			}
			result = firstNum / secondNum;
			break;
		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid operation!");
			return;
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Result: " + result);
		out.println("</body>");
		out.println("</html>");
	}
}
