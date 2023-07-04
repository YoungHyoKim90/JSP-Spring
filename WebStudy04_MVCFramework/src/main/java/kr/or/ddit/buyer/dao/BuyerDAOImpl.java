package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BuyerVO;

public class BuyerDAOImpl implements BuyerDAO {
	private SqlSessionFactory sqlSessionFactory = 
				CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertBuyer(BuyerVO buyer) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			BuyerDAO mapperProxy = sqlSession.getMapper(BuyerDAO.class);
			int cnt = mapperProxy.insertBuyer(buyer);
			sqlSession.commit();
			return cnt;
		}
	}

	@Override
	public BuyerVO selectBuyer(String buyerId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			BuyerDAO mapperProxy = sqlSession.getMapper(BuyerDAO.class);
			return mapperProxy.selectBuyer(buyerId);
		}
	}

	@Override
	public List<BuyerVO> selectBuyerList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			BuyerDAO mapperProxy = sqlSession.getMapper(BuyerDAO.class);
			return mapperProxy.selectBuyerList();
		}
	}

	@Override
	public int updateBuyer(BuyerVO buyer) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			BuyerDAO mapperProxy = sqlSession.getMapper(BuyerDAO.class);
			int cnt = mapperProxy.updateBuyer(buyer);
			sqlSession.commit(); // TCL(commit/rollback)
			return cnt;
		}
	}

	@Override
	public int deleteBuyer(String buyerId) {
		throw new IllegalStateException("거래처 정보 삭제는 지원하지 않습니다.");
//		try(
//			SqlSession sqlSession = sqlSessionFactory.openSession();	
//		){
//			BuyerDAO mapperProxy = sqlSession.getMapper(BuyerDAO.class);
//			int cnt = mapperProxy.deleteBuyer(buyerId);
//			sqlSession.commit(); // TCL(commit/rollback)
//			return cnt;
//		}
	}

}











