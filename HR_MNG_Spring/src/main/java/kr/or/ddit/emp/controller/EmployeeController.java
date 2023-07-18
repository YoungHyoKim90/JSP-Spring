package kr.or.ddit.emp.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.service.EmployeeService;
import kr.or.ddit.emp.vo.EmployeeVO;
import kr.or.ddit.emp.vo.Pagination;
import kr.or.ddit.ui.BootstrapPaginationRenderer;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController{
	private final EmployeeService service;
	
	@RequestMapping(value="/employees", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Pagination<EmployeeVO> employee(
		@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
		, Model model
		, @RequestParam Map<String,Object> parameterMap
	){
		Pagination<EmployeeVO> pagination = new Pagination<>(7,5);
		pagination.setCurrentPage(currentPage);
		
		parameterMap.forEach((name,value)->{
			Object condition = Optional.ofNullable(value)
									.map(Object::toString)
									.orElse("");
			pagination.addSearchCondtion(name, condition);
		});
		
		service.retrieveEmployees(pagination);
		
		pagination.setRenderer(new BootstrapPaginationRenderer());
		
		return pagination;
	}
}
