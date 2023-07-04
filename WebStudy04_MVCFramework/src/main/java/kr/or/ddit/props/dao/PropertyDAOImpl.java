package kr.or.ddit.props.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PropertyVO;

public class PropertyDAOImpl implements PropertyDAO {
	private SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertProperty(PropertyVO prop) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(false);	
		){
			PropertyDAO mapperProxy = sqlSession.getMapper(PropertyDAO.class);
			int cnt = mapperProxy.insertProperty(prop);
			sqlSession.commit();
			return cnt;
		}
	}

	@Override
	public PropertyVO selectProperty(String propertyName) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			PropertyDAO mapperProxy = sqlSession.getMapper(PropertyDAO.class);
			return mapperProxy.selectProperty(propertyName);
		}
	}

	@Override
	public List<PropertyVO> selectProperties() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
//			return sqlSession.selectList("kr.or.ddit.props.dao.PropertyDAO.selectProperties");
			PropertyDAO mapperProxy = sqlSession.getMapper(PropertyDAO.class);
			return mapperProxy.selectProperties();
		}
	}

	@Override
	public int updateProperty(PropertyVO prop) {
		// TODO Auto-generated method stub
		return 0;
	}

//	TDD (Test Driven Development)
	@Override
	public int deleteProperty(String propertyName) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);	
		){
			PropertyDAO mapperProxy = sqlSession.getMapper(PropertyDAO.class);
			return mapperProxy.deleteProperty(propertyName);
		}
	}

}
















