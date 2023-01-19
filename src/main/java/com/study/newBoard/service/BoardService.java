package com.study.newBoard.service;

import com.study.newBoard.entity.Board;
import com.study.newBoard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board){

        boardRepository.save(board);

    }
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    public Board getBoard(Integer id) {
        Optional<Board> board = this.boardRepository.findById(id);
        if (board.isPresent()) {
            return board.get();
        } else {
            throw new DataNotFoundException("정보가 없습니다.");
        }
    }

}
