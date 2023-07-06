package kr.or.ddit.case1.service;

import kr.or.ddit.case1.dao.Case1DAO;

public class Case1ServiceImpl implements Case1Service {
	// 객체 간의 의존관계 형성
	// 1. 의존 객체 직접 생성
//	private Case1DAO dao = new Case1DAOImpl();
	// 2. Factory Object Pattern 적용, factory 와 생성되는 객체 사이의 결합력 잔존.
//	private Case1DAO dao = new Case1DAOFactory().getCase1DAO();
//	3. Strategy Pattern(전략 패턴) : 전략 주입 방법과 전략 주입자(결합력 잔존)가 필요한 구조.
	private Case1DAO dao;
	
	public Case1ServiceImpl(Case1DAO dao) {
		super();
		this.dao = dao;
	}

	public void setDao(Case1DAO dao) {
		this.dao = dao;
	}

	@Override
	public StringBuilder retrieveCase1Info(String id) {
		String rawData = dao.selectCase1RawData(id);
		StringBuilder info = new StringBuilder(rawData);
		info.append(" 를 가공한 information");
		return info;
	}

}
