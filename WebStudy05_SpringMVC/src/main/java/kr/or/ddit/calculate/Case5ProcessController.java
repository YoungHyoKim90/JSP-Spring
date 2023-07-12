package kr.or.ddit.calculate;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1. request parameter / html response
 * 2. request parameter / json response
 * 
 * 3. request json payload / html response
 * 4. request json payload / json response
 *
 */
@RequestMapping("/calculate/Case5ProcessServlet")
@Controller
public class Case5ProcessController{
	
	@PostMapping(produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String parameterToHtml(CalculateVO commandObject){
		return commandObject.getExpr();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateVO parameterToJson(CalculateVO commandObject){
		return commandObject;
	}
	
	@PostMapping(produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String jsonToHtml(@RequestBody CalculateVO commandObject){
		return commandObject.getExpr();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateVO jsonToJson(@RequestBody CalculateVO commandObject){
		return commandObject;
	}	

}




















