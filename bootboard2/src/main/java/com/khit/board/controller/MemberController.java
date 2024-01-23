package com.khit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.khit.board.entity.Member;
import com.khit.board.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	// 로그인 페이지 요청
	@GetMapping("/member/login")
	public String getLogin() {
		return "/member/login";
	}
	
	// 로그인 처리
	@PostMapping("/member/login")
	public String login(@ModelAttribute Member member, HttpSession session) {
		Member loginMember = memberService.login(member);
		if(loginMember != null && loginMember.getPassword().equals(member.getPassword())) {
			// 아이디와 비밀번호가 일치해 로그인을 성공하면 세션 발급
			session.setAttribute("sessMemberId", loginMember.getMemberId());
			return "main";
		} else {
			return "/member/login";
		}
	}
	
	// 메인 페이지
	@GetMapping("/main")
	public String main() {
		return "main";
	}

}
