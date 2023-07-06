package kr.or.ddit.case3.dao;

import java.text.MessageFormat;

public class Case3DAOImpl_Mysql implements Case3DAO {

	@Override
	public String selectCase1RawData(String pk) {
		return MessageFormat.format("{0} 으로 Mysql에서 조회한 raw data", pk);
	}

}
