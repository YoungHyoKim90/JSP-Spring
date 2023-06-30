package kr.or.ddit.login.service;

import java.text.MessageFormat;

import kr.or.ddit.login.AuthenticateException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOimpl;
import kr.or.ddit.vo.MemberVO;

public class AuthenticateServiceImpl implements AuthenticateService {
	private MemberDAO dao = new MemberDAOimpl();
	
	@Override
	public MemberVO authenticate(MemberVO inputData) throws AuthenticateException {
		MemberVO saved = dao.selectMemberForAuth(inputData.getMemId());
		if(saved==null)
			throw new AuthenticateException(MessageFormat.format("{0} 해당 사용자는 없음.", inputData.getMemId()));
		String inputPass = inputData.getMemPass();
		String savedPass = saved.getMemPass();
		if(inputPass.equals(savedPass)) {
			return saved;
		}else {
			throw new AuthenticateException("비밀번호 오류");
		}
	}

}
