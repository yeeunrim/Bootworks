package com.khit.study.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.khit.study.entity.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// 게시글 생성
	@Test
	public void insertBoard() {
		/* Board board = new Board();
		board.setTitle("가입 인사");
		board.setWriter("임예은");
		board.setContent("안녕하세요. 반갑습니다.");
		board.setCreatedDate(new Timestamp(System.currentTimeMillis())); */
		
		/* Board board = Board.builder()
					  .title("테스트")
					  .writer("관리자")
					  .content("오늘 하루도 화이팅 ~")
					  .createdDate(new Timestamp(System.currentTimeMillis()))
					  .build(); 
		
		// db에 저장
		boardRepository.save(board); */
	}
	
	// 목록보기
	@Test
	public void getBoardList() {
		// db의 게시글 목록 가져오기
		List<Board> boardList = boardRepository.findAll();
		
		// boardList 출력
		/* for(Board board : boardList) {
			log.info(board.toString());
		} */
		
		// 람다식
		boardList.forEach(board -> log.info(board.toString()));
		
	} 
	
	// 1건 상세보기
	/* @Test
	public void getBoard() {
		// findById()를 사용
		Board board = boardRepository.findById(2).get();
		log.info(board.toString());
	} */
	
	// 수정하기
	/* @Test
	public void updateBoard() {
		// 수정하려는 게시글을 가져와서 : findById()
		Board board = boardRepository.findById(1).get();
		board.setTitle("가입인사");
		board.setContent("안녕하세요!");
		// 수정 처리 : save
		boardRepository.save(board);
	} */
	
	// 삭제하기
	/* @Test
	public void deleteBoard() {
		// 3번 게시글 삭제
		boardRepository.deleteById(3);
	} */
	
	
}
