package kr.or.ddit.servlet02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/03/dataProcess.do")
public class RequestParameterProcessServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Enumeration<String> params = req.getParameterNames();
		
		while (params.hasMoreElements()) {
			String param = params.nextElement();
			String[] values = req.getParameterValues(param);
			System.out.printf("%s : %s\n", param, Arrays.toString(values));
		}
		
		System.out.println("-----------------------------------");
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			String parameterName = entry.getKey();
			String[] values = entry.getValue();
			System.out.printf("%s : %s\n", parameterName,  Arrays.toString(values));
		}
		
		String accept =  req.getHeader("accept");
		String contentType = null;
		Object responseContent = null;
		
		if(accept.contains("json")) { 
			//Native Object
			Map<String, Object> target = new HashMap<>(); //VO를 대체할때 VO는 properties가 제일 중요. properties(이름+값)
			target.put("message","요청 처리 완료. 결과 메시지 전송");
			
			//Marshalling
			contentType = "applicaion/json;charset=UTF-8";
			//responseContent = "{\"message\":\"요청 처리 완료. 결과 메시지 전송\"}"; --> 이건 하드코딩
			
			ObjectMapper mapper = new ObjectMapper();
			responseContent = mapper.writeValueAsString(target);
			// Maven Repository
		}else {
			contentType = "text/plain;charset=UTF-8";
			responseContent = "요청 처리 완료. 결과 메시지 전송";
		}
		
		// Accept : text/plain
		//Serializetion
		resp.setContentType(contentType);
		try(PrintWriter out = resp.getWriter();){
			out.println(Objects.toString(responseContent,""));
		}
		
	}

}
