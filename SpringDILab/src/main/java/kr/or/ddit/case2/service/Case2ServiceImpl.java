package kr.or.ddit.case2.service;

import kr.or.ddit.case2.dao.Case2DAO;

public class Case2ServiceImpl implements Case2Service {

	private Case2DAO dao;
	
	public Case2ServiceImpl(Case2DAO dao) {
		super();
		this.dao = dao;
	}

	public void setDao(Case2DAO dao) {
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
