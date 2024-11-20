package com.codingrecipe.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardFileDTO {
    private Long id;
    private Long boardId;
    private String originalFileName;    // 사용자가 올린 원본 File Name
    private String storedFileName;      // 저장을 위한 File Name (사용자가 중복 이름인 File 을 올릴 수도 있으니, 저장될 때마다 약간의 data 를 추가해서 저장하는 이름이 필요)
}
