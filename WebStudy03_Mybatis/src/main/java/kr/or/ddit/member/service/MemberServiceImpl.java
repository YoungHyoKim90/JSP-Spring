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
		} catch (PKNotFoundException e) {
			int cnt = memberDAO.insertMember(member);
			result = cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public MemberVO retrieveMember(String memId) throws PKNotFoundException {
		MemberVO saved = memberDAO.selectMember(memId);
		if (saved == null)
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
		} catch (AuthenticateException e) {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

	@Override
	public ServiceResult removeMember(MemberVO member) {
		ServiceResult result = null;
		// OK, FAIL, PKDUPLICATE, INVALIDPASSWORD를 enum으로 가지고 있는 ServiceResultdml
		// result값
		try {
			authService.authenticate(member);
			// authService 객체의 authenticate 메서드를 호출하여 member 객체를 인수로 전달합니다. 삭제를 진행하기 전에 자격
			// 증명이 유효한지 확인하여 구성원을 인증할 책임이 있을 수 있습니다.
			int cnt = memberDAO.deleteMember(member.getMemId());
			// memberDAO 객체의 deleteMember 메서드를 호출하여 member 객체에서 memId(아마도 회원 ID)를 전달합니다. .
			// 메서드는 삭제 작업을 수행하고 영향을 받는 행 수를 반환할 것
			result = cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
			// cnt 값을 기반으로
			// result 변수에 값을 할당. cnt가 0보다 크면(성공적인 삭제를 나타냄)
			// result는 ServiceResult.OK로 설정됩니다.
			// 그렇지 않으면 ServiceResult.FAIL로 설정됩니다.
		} catch (AuthenticateException e) { // AuthenticateException가 발생하는 것은 사용자가 인증과정에서 잘못된 정보나, 양식을 입력하였을 경우 발생한다.
			result = ServiceResult.INVALIDPASSWORD;
			// AuthenticateException이 발생하는 경우 ServiceResult에 INVALIDPASSWORD 값을 넣어 result에
			// 할당한다.
		}
		return result;
		// removeMember 작업의 결과를 나타내는 result 변수를 반환합니다.

	}

}
