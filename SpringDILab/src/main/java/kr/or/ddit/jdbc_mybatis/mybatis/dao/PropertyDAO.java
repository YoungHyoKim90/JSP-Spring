package kr.or.ddit.jdbc_mybatis.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.jdbc_mybatis.vo.PropertyVO;

@Mapper
public interface PropertyDAO {
	public List<PropertyVO> selectPropertyList();
}
