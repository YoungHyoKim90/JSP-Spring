package kr.or.ddit.case1.view;

import java.text.MessageFormat;

import kr.or.ddit.case1.dao.Case1DAO;
import kr.or.ddit.case1.dao.Case1DAOImpl;
import kr.or.ddit.case1.dao.Case1DAOImpl_Mysql;
import kr.or.ddit.case1.service.Case1Service;
import kr.or.ddit.case1.service.Case1ServiceImpl;

public class Case1View {
	private Case1DAO dao = new Case1DAOImpl_Mysql();
	private Case1Service service = new Case1ServiceImpl(dao);
	public String generateContent(String id) {
		StringBuilder model = service.retrieveCase1Info(id);
		return MessageFormat.format("{0} 로 만든 컨텐츠 메시지", model);
	}
}
