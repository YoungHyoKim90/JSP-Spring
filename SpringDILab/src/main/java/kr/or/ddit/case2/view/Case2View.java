package kr.or.ddit.case2.view;

import java.text.MessageFormat;

import kr.or.ddit.case2.service.Case2Service;

public class Case2View {
	private Case2Service service;
	public void setService(Case2Service service) {
		this.service = service;
	}
	public String generateContent(String id) {
		StringBuilder model = service.retrieveCase1Info(id);
		return MessageFormat.format("{0} 로 만든 컨텐츠 메시지", model);
	}
}
