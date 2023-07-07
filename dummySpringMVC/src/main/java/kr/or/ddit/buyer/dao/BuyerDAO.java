package kr.or.ddit.buyer.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.buyer.vo.BuyerVO;

@Mapper
public interface BuyerDAO {
	public BuyerVO selectBuyer(String buyerId); 
		
	
}
