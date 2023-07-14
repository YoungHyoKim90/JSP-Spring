package kr.or.ddit.board.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.board.vo.FreeboardVO;

@Mapper
public interface FreeboardDAO {
	public int insertBoard(FreeboardVO board);
}
