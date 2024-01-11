package com.khit.study.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.khit.study.entity.BoardVO;

@Service
public class BoardService {

	// 상세보기
	public BoardVO getBoard() {
		// 게시글 1개 생성
		BoardVO board = new BoardVO();
		board.setId(1);
		board.setTitle("제목");
		board.setWriter("임예은");
		board.setContent("빨리 집에 갈래");
		board.setCreatedDate(new Date());
		return board;
	}
	
	// 목록 보기
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			BoardVO board = new BoardVO();
			board.setId(1);
			board.setTitle("제목 : " + i);
			board.setWriter("임예은");
			board.setContent("빨리 집에 갈래");
			board.setCreatedDate(new Date());
			boardList.add(board);
		}
		return boardList;
	}
	
}
