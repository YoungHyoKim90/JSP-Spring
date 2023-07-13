package kr.or.ddit.teaching.dao;

import java.util.List;

import kr.or.ddit.common.DAOIfs;
import kr.or.ddit.vo.TeachingVO;

/**
 * 강의관리용 Persistence Layer
 */
public interface TeachingDAO extends DAOIfs<TeachingVO> {
	/**
	 * 특정 교수의 강의리스트 조회
	 * @param proCd 
	 * @return 강의 리스트, 없으면 size = 0
	 */
	public List<TeachingVO> selecListByProCd(String proCd);
}
