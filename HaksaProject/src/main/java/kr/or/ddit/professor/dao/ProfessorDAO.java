package kr.or.ddit.professor.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.DAOIfs;
import kr.or.ddit.vo.ProfessorVO;

/**
 * 교수관리용 Persistence Layer
 */
@Mapper
public interface ProfessorDAO {
	/**
	 * 사용자 인증을 위한 메소드
	 * @param inputData : 부서코드, 교수코드 포함
	 * @return 인증된 교수 정보, 없으면 null 반환
	 */
	public ProfessorVO selectForAuth(ProfessorVO inputData);
}
