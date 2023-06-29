package kr.co.yhk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/T04login2")
public class T04login2 extends HttpServlet {
	
	@Override
	public void init() throws ServletException {

		System.out.println("init메서드 호출");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		System.out.println("입력받은 유저 아이디 :" + user_id);
		System.out.println("입력받은 유저 비밀번호 :" +user_pw);
		// user_id를 req(요청)의 user_id의 파라미터를 받아온다!
		
//		String[] name = req.getParameterValues("name");
//		같은 name에 대해 여러 개의 값을 얻을 때 사용.
		
//		Enumeration getParameterName() //name의 값을 모를 때 사용합니다.		
		
		String data = "<html>";
		data += "<body>";
		if(data!=null || data != ""||data !=" ") {
		data += "아이디:" + user_id;
		}else {
			data += "아이디: 잘못입력하셨습니다.";
		}
		data += "<br>";
		data += "비밀번호 :" + user_pw;
		data += "<br>";
		data += "</body>";
		data += "</html>";
		out.print(data);
	
	}
	
	@Override
	public void destroy() {

		System.out.println("destroy메서드 호출");
	
	}
	
}