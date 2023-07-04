package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

public class OthersDAOImpl implements OthersDAO {
	private SqlSessionFactory sqlSessionFactory = 
				CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<LprodVO> selectLprodList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			return sqlSession.selectList("kr.or.ddit.prod.dao.OthersDAO.selectLprodList");
		}
	}

	@Override
	public List<BuyerVO> selectBuyerList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			return sqlSession.selectList("kr.or.ddit.prod.dao.OthersDAO.selectBuyerList");
		}
	}

}
