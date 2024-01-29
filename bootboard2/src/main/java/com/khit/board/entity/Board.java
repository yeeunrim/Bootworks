package com.khit.board.entity;

import java.util.List;

import com.khit.board.dto.BoardDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString(exclude = "member")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_board")
@Entity
public class Board extends BaseEntity{
	
	@Id                                                   // PK (Primary Key)
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // 자동순번
	private Integer id;                                   // 글 번호
	
	@Column(nullable = false)                             // Not Null
	private String title;                                 // 제목
	
	@Column(length = 2000, nullable = false)              // 최대 2000자 & Not Null
	private String content;                               // 내용
	
	// Board Entity와 연관관계 매핑 - 다대일 (多:1)
	// fetch는 조회할 때 사용한다.
	// EAGER : 전제 조회 & LAZY : 특정한 조회
	// JoinColumn(name = "설정 이름") : 외래키 설정
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")                       // FK (Foreign Key) 설정
	private Member member;
	
	// 1쪽이 board가 주인이 아님
	// 게시글이 삭제되면 댓글도 삭제됨
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	@OrderBy("id desc")
	private List<Reply> replyList;
	
	// dto -> entity
	// 글 작성
	public static Board toSaveEntity(BoardDTO boardDTO) {
		Board board = Board.builder()
						   .title(boardDTO.getTitle())
						   .content(boardDTO.getContent())
						   .member(boardDTO.getMember())
						   .build();
		
		return board;
	}
	
	// 글 수정
	public static Board toUpdateEntity(BoardDTO boardDTO) {
		Board board = Board.builder()
						   .id(boardDTO.getId())
						   .title(boardDTO.getTitle())
						   .content(boardDTO.getContent())
						   .member(boardDTO.getMember())
						   .build();
		
		return board;
	}
	

}
