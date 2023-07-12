package kr.or.ddit.vo;

import java.security.Principal;

public class MemberVOWrapper implements Principal{
	private MemberVO realUser;

	public MemberVOWrapper(MemberVO realUser) {
		super();
		this.realUser = realUser;
	}

	@Override
	public String getName() { //getName는 식별자를 의미한다.
		return realUser.getMemId();
	}
	
	public MemberVO getRealUser() {
		return realUser;
	}
	
}
