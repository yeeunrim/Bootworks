package com.khit.study.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.khit.study.entity.Board;
import com.khit.study.repository.BoardRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardService {
	
	private BoardRepository boardRepository;

	public void save(Board board) {
		boardRepository.save(board);
	}

	public List<Board> findAll() {
		return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	public Board findById(int id) {
		// 1건 검색할 때에는 .get()까지 사용한다.
		return boardRepository.findById(id).get();
	}

	public void deleteById(int id) {
		boardRepository.deleteById(id);
	}

	public void update(Board board) {
		board.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		boardRepository.save(board);
	}
	
}
