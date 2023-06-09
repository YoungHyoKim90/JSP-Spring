package kr.or.ddit.prod.service;

import java.text.MessageFormat;
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
		return prodDAO.insertProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL; 
	}

	@Override
	public ProdVO retrieveProd(String prodId) throws PKNotFoundException {
		ProdVO prod = prodDAO.selectProd(prodId);
		if(prod==null)
			throw new PKNotFoundException(MessageFormat.format("{0} 해당 상품 없음", prodId));
		return prod;
	}

	@Override
	public List<ProdVO> retrieveProdList() {
		return prodDAO.selectProdList();
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		return prodDAO.updateProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

}
