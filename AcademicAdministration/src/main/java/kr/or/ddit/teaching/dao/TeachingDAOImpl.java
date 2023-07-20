package kr.or.ddit.teaching.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.teaching.vo.TeachingVO;

public class TeachingDAOImpl implements TeachingDAO {

	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insert(TeachingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TeachingVO> selectAll() {
		try (
			SqlSession sqlSession = sqlSessionFactory.openSession();
		) {
			TeachingDAO mapperProxy = sqlSession.getMapper(TeachingDAO.class);
			return mapperProxy.selectAll();
		}
	}

	@Override
	public TeachingVO select(TeachingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TeachingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TeachingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TeachingVO> selecListByProCd(String proCd) {
		try (
			SqlSession sqlSession = sqlSessionFactory.openSession();
		) {
			TeachingDAO mapperProxy = sqlSession.getMapper(TeachingDAO.class);
			return mapperProxy.selecListByProCd(proCd);
		}
	}

}
