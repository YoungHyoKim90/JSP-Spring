package kr.or.ddit.calculate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumpkg.OperatorType;

@Controller
@RequestMapping("/calculate/Case3ProcessServlet")
public class Case3ProcessController{
	private static final long serialVersionUID = 1L;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	protected void json(
				@RequestParam("leftOp") double left
			,	@RequestParam("rightOp") double right
			,	@RequestParam("opParam") OperatorType operator
			){
	
	
			double result = operator.biOperate(left, right);
			return operator.expression(left, right);
			
			// native
			String accept = request.getHeader("accept");
			String contentType = null;
			Object content = null;
			if(accept.contains("json")) {
				contentType = "application/json;charset=UTF-8";
				content = new ObjectMapper().writeValueAsString(target);
			}else if(accept.contains("xml")) {
				response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
				return;
			}else {
				contentType = "text/html;charset=UTF-8";
				content = target.get("expr");
			}
			
			response.setContentType(contentType);
			
			try(
				PrintWriter out = response.getWriter();	
			){
				out.println(content);
			}
		}
	}






















