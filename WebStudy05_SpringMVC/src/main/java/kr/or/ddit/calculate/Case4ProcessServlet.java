package kr.or.ddit.calculate;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumpkg.OperatorType;

@Controller
@RequestMapping("/calculate/Case4ProcessServlet")
public class Case4ProcessServlet {

//	@RequestBody : 요청 payload를 언마샬링 할때 사용 . (consumes과 함께사용)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateVO jsonPayload(@RequestBody CalculateVO commandObject) {
		return commandObject;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateVO parameter(CalculateVO commandObject) {
		return commandObject;
	}

}
