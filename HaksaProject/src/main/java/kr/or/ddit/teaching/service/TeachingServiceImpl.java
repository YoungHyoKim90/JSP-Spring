package kr.or.ddit.teaching.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.teaching.dao.TeachingDAO;
import kr.or.ddit.teaching.dao.TeachingDAOImpl;
import kr.or.ddit.vo.TeachingVO;

public class TeachingServiceImpl implements TeachingService {

	private TeachingDAO dao = new TeachingDAOImpl();
	
	@Override
	public ServiceResult create(TeachingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeachingVO> retrieveAll() {
		return dao.selectAll();
	}

	@Override
	public TeachingVO retrieve(TeachingVO vo) throws PKNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult modify(TeachingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult remove(TeachingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeachingVO> retrieveListByProCd(String proCd) {
		return dao.selecListByProCd(proCd);
	}

}
