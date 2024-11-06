package com.codingrecipe.board.controller;

import com.codingrecipe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")        // url 이름
    public String save() {      // java method 이름
        return "save";          // return 할 화면의 이름
    }
}
