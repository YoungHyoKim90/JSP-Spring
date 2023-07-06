package kr.or.ddit.case2.dao;

import java.text.MessageFormat;

public class Case2DAOImpl_Mysql implements Case2DAO {

	@Override
	public String selectCase1RawData(String pk) {
		return MessageFormat.format("{0} 으로 Mysql에서 조회한 raw data", pk);
	}

}
