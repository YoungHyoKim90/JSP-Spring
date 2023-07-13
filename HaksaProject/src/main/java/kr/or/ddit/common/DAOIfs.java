package kr.or.ddit.common;

import java.util.List;

/**
 * 공통으로 사용되는 CRUD DAO 인터페이스
 */
public interface DAOIfs<T> {
	/**
	 * 데이터 추가
	 * @param vo
	 * @return 추가된 레코드 수 반환, > 0 성공
	 */
	int insert(T vo);
	/**
	 * 전체 데이터 조회
	 * @return 전체 리스트, 없으면 size = 0
	 */
	List<T> selectAll();
	/**
	 * 특정 데이터 조회
	 * @param vo : 식별자 포함
	 * @return 조회된 데이터, 없으면 null 반환
	 */
	T select(T vo);
	/**
	 * 데이터 수정
	 * @param vo
	 * @return 수정된 레코드 수 반환, > 0 성공
	 */
	int update(T vo);
	/**
	 * 데이터 삭제
	 * @param vo
	 * @return 삭제된 레코드 수 반환, > 0 성공
	 */
	int delete(T vo);
}
