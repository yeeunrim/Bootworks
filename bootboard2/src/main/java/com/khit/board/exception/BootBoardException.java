package com.khit.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BootBoardException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	// 생성자
	public BootBoardException(String message) {
		super(message);
	}
	
}
