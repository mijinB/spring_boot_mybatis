package com.codingrecipe.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class BoardDTO {
    /**
     * HTML 의 name 이 아래 필드와 동일한 이름이여야 한다.
     *  => Controller 에서 잘 받기 위함
     *      BoardController.java 의 PostMapping("/save") 에서 매개변수(BoardDTO boardDTO)를 받아서 (=HTML 에서 Post 한 data 가 boardDTO)
     *      현재 BoardDTO 클래스의 필드 이름과 동일하고 setter 가 있다면 자동으로 값을 담아주는 작업을 Spring 이 중간에서 진행해준다.
     */
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private String createdAt;
    private int fileAttached;           // 파일의 유(1) 무(0)
    private MultipartFile boardFile;    // 파일 자체를 담기위함
}
