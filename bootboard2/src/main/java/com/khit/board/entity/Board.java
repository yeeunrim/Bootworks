package com.khit.board.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "member")
@Setter
@Getter
@Table(name = "t_board")
@Entity
public class Board{
	
	@Id                                                   // PK (Primary Key)
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // 자동순번
	private Integer Id;                                   // 글 번호
	
	@Column(nullable = false)                             // Not Null
	private String title;                                 // 제목
	
	@Column(length = 2000, nullable = false)              // 최대 2000자 & Not Null
	private String content;                               // 내용
	
	@CreationTimestamp
	private Timestamp createdDate;                        // 작성일
	
	// Board Entity와 연관관계 매핑 - 다대일 (多:1)
	// fetch는 조회할 때 사용한다.
	// EAGER : 전제 조회 & LAZY : 특정한 조회
	// JoinColumn(name = "설정 이름") : 외래키 설정
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")                       // FK (Foreign Key) 설정
	private Member member;

}
