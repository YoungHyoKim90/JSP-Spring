package kr.or.ddit.member.service;

import java.text.MessageFormat;
import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;
import lombok.Data;

public class MemberServiceImpl implements MemberService {
	
	// 의존관계 형성 --> 결합력 발생 --> 차후 DI(Dependency Injection) 구조로 해결.
	private MemberDAO memberDAO = new MemberDAOImpl();

	@Override
	public ServiceResult createMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public ServiceResult modifyMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

}
