package kr.or.ddit.case3.service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.case3.dao.Case3DAO;

@Service
public class Case3ServiceImpl implements Case3Service {
//	@Resource(name="case3Mysql")
	private Case3DAO dao;
	
//	@Autowired
	@Inject
	@Named("case3DAOImpl")
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
