package kr.or.ddit.login.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.login.AuthenticateException;
import kr.or.ddit.professor.dao.ProfessorDAO;
import kr.or.ddit.professor.vo.ProfessorVO;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
	@Inject
	private ProfessorDAO dao;

	@Override
	public ProfessorVO authenticate(ProfessorVO inputData) throws AuthenticateException {
		ProfessorVO saved = dao.selectForAuth(inputData);
		if (saved == null) throw new AuthenticateException("등록되지 않은 사용자");
		return saved;
	}

}
