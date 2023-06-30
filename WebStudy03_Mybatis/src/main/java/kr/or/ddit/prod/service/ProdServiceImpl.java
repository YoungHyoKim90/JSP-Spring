package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements ProdService {
	private ProdDAO prodDAO = new ProdDAOImpl();

	@Override
	public ServiceResult createProd(ProdVO prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdVO retrieveProd(String prodId) throws PKNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdVO> retrieveProdList() {
		return prodDAO.selectProdList();
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		// TODO Auto-generated method stub
		return null;
	}

}
