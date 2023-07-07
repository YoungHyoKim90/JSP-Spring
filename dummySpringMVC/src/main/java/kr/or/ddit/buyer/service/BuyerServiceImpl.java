package kr.or.ddit.buyer.service;

import org.springframework.stereotype.Service;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.buyer.vo.BuyerVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BuyerServiceImpl implements BuyerService {
	
	
	private final BuyerDAO dao;
	




	@Override
	public BuyerVO retrieveBuyer(String buyerId) {
		
		return dao.selectBuyer(buyerId);
	}

}
