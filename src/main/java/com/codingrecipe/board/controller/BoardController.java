package com.codingrecipe.board.controller;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/list")
    public String findAll(Model model) {
        /**
         * Model : data 를 화면(html)으로 가져갈 수 있도록 전달해주는 객체이다. (뭔가 가져갈 게 있다면 Model 을 매개변수에 추가해주면 된다.)
         * 요즘은 RESTful API 를 많이 사용하는데, RESTful API 에서는 Model 객체를 쓸 일은 없다. 모든걸 다 HTTP body 에 JSON 형태로 return 을 주고있기 때문.
         */
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        System.out.println("boardDTOList = " + boardDTOList);
        return "list";
    }
}
