package com.codingrecipe.board.controller;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")        // url 이름
    public String save() {      // java method 이름
        return "save";          // return 할 화면의 이름
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDTO) {
//  public String save(@ModelAttribute BoardDTO boardDTO) {       @ModelAttribute 은 생략 가능해서 생략한 것
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "index";
    }
}
