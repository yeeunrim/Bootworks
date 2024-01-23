package com.khit.board.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "boardList")
@Setter
@Getter
@Table(name = "t_member")
@Entity
public class Member {
	
	@Id                                                   // PK (Primary Key)
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // 자동순번
	private Integer id;                                   // 회원 번호
	
	@Column(name = "member_id", unique = true)            // FK (Foreign Key) - 관계 맺기 위함 & 중복 X
	private String memberId;                              // 아이디 (로그인)
	
	@Column(nullable = false)                             // Not Null
	private String password;                              // 비밀번호 (로그인)
	
	@Column(nullable = false, length = 30)                // Not Null & 최대 30자
	private String name;                                  // 이름
	
	@Column
	// private String role;                               // 권한
	@Enumerated(EnumType.STRING)
	private Role role;
	
	// Board와 관계 매핑 - @OneToMany : 한 명의 회원은 여러 개의 글을 작성할 수 있다.
	// 주인 설정 필요 - mappedBy : 다(多)쪽이 주인
	// 삭제 - cascade : 회원이 삭제되면 작성한 글 또한 함께 삭제된다.
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Board> boardList = new ArrayList<>();

}