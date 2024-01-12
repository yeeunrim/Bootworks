package com.khit.study.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.study.entity.Board;
import com.khit.study.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

	private BoardService boardService;
	
	// 글쓰기 페이지
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	// 글쓰기 처리
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		log.info("board : " + board);
		boardService.save(board);
		return "redirect:/board/";
	}
	
	// 글 목록
	@GetMapping("/")
	public String getBoardList(Model model) {
		List<Board> boardList = boardService.findAll();
		model.addAttribute("boardList", boardList);
		return "/board/list";
	}
	
	// 글 상세보기
	// board?id=1
	@GetMapping
	public String getBoard(@RequestParam("id") int id, Model model) {
		Board board = boardService.findById(id);
		model.addAttribute("board", board);
		return "/board/detail";
	}
	
	// 글 수정 페이지
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") int id, Model model) {
		Board board = boardService.findById(id);
		model.addAttribute("board", board);
		return "/board/update";
	}
	
	// 글 수정 처리
	@PostMapping("/update")
	public String update(@ModelAttribute Board board) {
		boardService.save(board);
		return "redirect:/board?id=" + board.getId();
	}
	
	// 글 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		boardService.deleteById(id);
		return "redirect:/board/";
	}
	
}
