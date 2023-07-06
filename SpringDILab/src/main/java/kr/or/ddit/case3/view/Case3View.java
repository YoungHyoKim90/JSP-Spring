package kr.or.ddit.case3.view;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.or.ddit.case3.service.Case3Service;

@Controller
public class Case3View {
	private Case3Service service;
	@Autowired
	public void setService(Case3Service service) {
		this.service = service;
	}
	public String generateContent(String id) {
		StringBuilder model = service.retrieveCase1Info(id);
		return MessageFormat.format("{0} 로 만든 컨텐츠 메시지", model);
	}
}
