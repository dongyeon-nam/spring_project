package com.study.newBoard.controller;

import com.study.newBoard.entity.Board;
import com.study.newBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // localhost:8080/board/write
    public String boardWriteForm(){

        return "boardwrite";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/board/list";
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

    @GetMapping("/board/view/{id}")
    public String boardView(Model model, @PathVariable("id") Integer id){
        Board board = this.boardService.getBoard(id);
            model.addAttribute("view", board);
        return "boardview";
    }


}

