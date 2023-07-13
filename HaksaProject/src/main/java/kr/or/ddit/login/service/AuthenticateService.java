package kr.or.ddit.login.service;

import kr.or.ddit.login.AuthenticateException;
import kr.or.ddit.vo.ProfessorVO;

/**
 * 인증 시스템을 위한 Business Logic Layer
 */
public interface AuthenticateService {
	/**
	 * 인증 여부를 판단하기 위한 로직
	 * @param inputData
	 * @return 인증에 성공한 사용자에 대한 정보 반환
	 * @throws AuthenticateException 인증 실패시 발생 예외
	 */
	public ProfessorVO authenticate(ProfessorVO inputData) throws AuthenticateException;
}
