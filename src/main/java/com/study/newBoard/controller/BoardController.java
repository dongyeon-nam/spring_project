package com.study.newBoard.controller;

import com.study.newBoard.entity.Board;
import com.study.newBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // localhost:8080/board/write
    public String boardWriteForm(){

        return "boardwrite";
    }
    @PostMapping("/board/writepro")
    public String BoardWritePro(Board board) {

        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {
        model.addAttribute("list",boardService.boardList());
        return "boardlist";
    }

    @GetMapping("/board/view")
    public String boardView(){
        return "boardview";
    }
}
