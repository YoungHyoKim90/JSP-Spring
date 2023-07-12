package kr.or.ddit.calculate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.OperatorType;

@Controller
public class Case1ProcessServlet{
	private static final long serialVersionUID = 1L;

	@PostMapping(value = "/calculate/Case1ProcessServlet", produces = "text/html;chatset=UTF-8")
	@ResponseBody // 컨트롤러의 반환값이 response body 의 컨텐츠로 사용될 때.(produeces 속성과 함께 사용)
	protected String doPost(
			@RequestParam double leftOp
			,@RequestParam double rightOp
			, OperatorType opParam
			){
			double result = opParam.biOperate(leftOp, rightOp);
			
			return opParam.expression(leftOp,rightOp);
			
	}

}




















