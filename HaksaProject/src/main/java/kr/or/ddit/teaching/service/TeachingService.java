package kr.or.ddit.teaching.service;

import java.util.List;

import kr.or.ddit.common.ServiceIfs;
import kr.or.ddit.vo.TeachingVO;

/**
 * 강의관리용 Business Logic Layer
 */
public interface TeachingService extends ServiceIfs<TeachingVO> {
	/**
	 * 특정 교수의 강의 목록 조회
	 * @param proCd
	 * @return 강의 리스트, 없으면 size = 0
	 */
	public List<TeachingVO> retrieveListByProCd(String proCd);
}
