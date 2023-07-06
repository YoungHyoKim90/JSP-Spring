package kr.or.ddit.case3.service;

import kr.or.ddit.case3.dao.Case3DAO;

public class Case3ServiceImpl implements Case3Service {

	private Case3DAO dao;
	
	public Case3ServiceImpl(Case3DAO dao) {
		super();
		this.dao = dao;
	}

	public void setDao(Case3DAO dao) {
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
