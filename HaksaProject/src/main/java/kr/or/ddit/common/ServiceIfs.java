package kr.or.ddit.common;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;

/**
 * 공통으로 사용되는 CRUD Service 인터페이스
 */
public interface ServiceIfs<T> {
	/**
	 * 객체 추가
	 * @param vo
	 * @return 성공(OK), 실패(FAIL)
	 * # 클라이언트로부터 PK 값을 받아오는 경우, PK중복(PKDUPLICATE) 추가 
	 */
	ServiceResult create(T vo);
	/**
	 * 전체 객체 조회
	 * @return 객체 리스트, 없으면 size = 0
	 */
	List<T> retrieveAll();
	/**
	 * 특정 객체 조회
	 * @param vo : 식별자 포함
	 * @return 존재하는 경우, 객체 정보 반환
	 * @throws PKNotFoundException : 해당하는 객체가 없을 때 발생
	 */
	T retrieve(T vo) throws PKNotFoundException;
	/**
	 * 객체 수정
	 * @param vo
	 * @return 성공(OK), 실패(FAIL)
	 * # 인증이 필요한 경우, 인증실패(AUTHFAIL) 추가
	 */
	ServiceResult modify(T vo);
	/**
	 * 객체 삭제
	 * @param vo
	 * @return 성공(OK), 실패(FAIL)
	 * # 인증이 필요한 경우, 인증실패(AUTHFAIL) 추가
	 */
	ServiceResult remove(T vo);
}
