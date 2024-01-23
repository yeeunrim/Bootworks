package com.khit.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.khit.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
   //기본 제공 메서드 - save(), findAll(), findById(), deleteById()
   @Modifying  //변경이 생겼을때 사용하는 애너테이션
   @Query(value="update Board b set b.boardHits= b.boardHits+1 where b.id=:id")
   void updateHits(Long id);

   //제목으로 검색하고 페이지 처리
   Page<Board> findByBoardTitleContaining(String keyword, Pageable pageable);

   Page<Board> findByBoardContentContaining(String keyword, Pageable pageable);
   
}