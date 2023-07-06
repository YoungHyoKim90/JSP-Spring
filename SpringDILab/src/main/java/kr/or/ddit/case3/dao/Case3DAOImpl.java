package kr.or.ddit.case3.dao;

import java.text.MessageFormat;

import org.springframework.stereotype.Repository;

@Repository
public class Case3DAOImpl implements Case3DAO {

	@Override
	public String selectCase1RawData(String pk) {
		return MessageFormat.format("{0} 으로 Oracle에서 조회한 raw data", pk);
	}

}
