package com.study.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.study.newBoard.BoardApplication;
import com.study.newBoard.entity.Board;
import com.study.newBoard.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = BoardApplication.class)
class BoardApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

	@Test
	void testJpa() {
		Board b = this.boardRepository.findByTitle("남동연");
		assertEquals(1,b.getId());



	}


}
