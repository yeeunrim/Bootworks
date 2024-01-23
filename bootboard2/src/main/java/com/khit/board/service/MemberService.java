package com.khit.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.khit.board.entity.Member;
import com.khit.board.entity.Role;
import com.khit.board.exception.BootBoardException;
import com.khit.board.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	private final PasswordEncoder pwEncoder;

	public Member login(Member member) {
		// DB에서 아이디 조회
		Optional<Member> findMember = memberRepository.findByMemberId(member.getMemberId());
		if(findMember.isPresent()) {
			return findMember.get();
		} else {
			return null;
		}
	}

	public void save(Member member) {
		// 1. 비밀번호 암호화
		// 2. 권한 설정
		String encPw = pwEncoder.encode(member.getPassword());
		member.setRole(Role.MEMBER);
		member.setPassword(encPw);
		memberRepository.save(member);
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public Member findById(Integer id) {
		Optional<Member> findMember = memberRepository.findById(id);
		if(findMember.isPresent()) {
			return findMember.get();
		} else {
			throw new BootBoardException("페이지를 찾을 수 없습니다.");
		}
	}

	public void deleteById(Integer id) {
		memberRepository.deleteById(id);
	}

}
