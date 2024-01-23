package com.khit.board.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.khit.board.entity.Member;

public class SecurityUser extends User{
	
	private static final long serialVersionUID = 1L;
	
	private Member member;
	
	// 3가지 파리미터 : username, password, role
	public SecurityUser(Member member) {
		// 암호화 되지 않은 상태 : {noop}
		super(member.getMemberId(), member.getPassword(), 
			  AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}

}
