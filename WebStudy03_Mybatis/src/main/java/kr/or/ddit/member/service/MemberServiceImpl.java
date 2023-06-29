package kr.or.ddit.member.service;

import java.text.MessageFormat;
import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.login.AuthenticateException;
import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.login.service.AuthenticateServiceImpl;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	// 의존관계 형성 --> 결합력 발생 --> 차후 DI(Dependency Injection) 구조로 해결.
	private MemberDAO memberDAO = new MemberDAOImpl();
	private AuthenticateService authService = new AuthenticateServiceImpl();

	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		try {
			retrieveMember(member.getMemId());
			result = ServiceResult.PKDUPLICATE;
		}catch (PKNotFoundException e) {
			int cnt = memberDAO.insertMember(member);
			result = cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}		
		return result;
	}

	@Override
	public MemberVO retrieveMember(String memId) throws PKNotFoundException {
		MemberVO saved = memberDAO.selectMember(memId);
		if(saved==null)
			throw new PKNotFoundException(MessageFormat.format("{0} 해당 사용자 없음.", memId));
		return saved;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		return memberDAO.selectMemberList();
	}

//	LA ? HCLC , Layer 들에게 단일 책임을 부여해서 응집력을 높임.
//				Layer 사이에서 발생하는 의존관계에 따라 결합력이 발생함.
	
	@Override
	public ServiceResult modifyMember(MemberVO member) {
		ServiceResult result = null;
		try {
			authService.authenticate(member);
			int cnt = memberDAO.updateMember(member);
			result = cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}catch (AuthenticateException e) {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

	@Override
	public ServiceResult removeMember(MemberVO member) {
		ServiceResult result = null;
		try {
			authService.authenticate(member);
			int cnt = memberDAO.deleteMember(member.getMemId());
			result = cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}catch (AuthenticateException e) {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

}

















