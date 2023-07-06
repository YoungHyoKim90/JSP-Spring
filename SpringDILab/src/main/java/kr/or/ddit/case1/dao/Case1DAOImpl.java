package kr.or.ddit.case1.dao;

import java.text.MessageFormat;

public class Case1DAOImpl implements Case1DAO {

	@Override
	public String selectCase1RawData(String pk) {
		return MessageFormat.format("{0} 으로 Oracle에서 조회한 raw data", pk);
	}

}
