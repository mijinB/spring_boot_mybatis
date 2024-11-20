package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.dto.BoardFileDTO;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) throws IOException {
        // 파일이 없을 때,
        if (boardDTO.getBoardFile().isEmpty()) {
            boardDTO.setFileAttached(0);
            boardRepository.save(boardDTO);
        // 파일이 있을 때,
        } else {
            boardDTO.setFileAttached(1);
            // 게시글 저장 후 id값 활용을 위해 리턴 받음.
            BoardDTO savedBoard = boardRepository.save(boardDTO);
            // 파일만 따로 가져오기
            MultipartFile boardFile = boardDTO.getBoardFile();
            // 파일 이름 가져오기
            String originalFilename = boardFile.getOriginalFilename();
            System.out.println("originalFilename = " + originalFilename);
            // 저장용 이름 만들기
            System.out.println(System.currentTimeMillis());     // UTC 기준으로 1970년 1월 1일 부터 몇 ms(밀리초)가 지났는지를 주는 메서드.
            String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
            System.out.println("storedFileName = " + storedFileName);
            // BoardFileDTO 세팅
            BoardFileDTO boardFileDTO = new BoardFileDTO();
            boardFileDTO.setOriginalFileName(originalFilename);
            boardFileDTO.setStoredFileName(storedFileName);
            boardFileDTO.setBoardId(savedBoard.getId());
            // 파일 저장용 폴더에 파일 저장 처리
            String savePath = "/Users/baegmijin/Documents/study/java/codingrecipe/spring_upload_files" + storedFileName; // mac
//              String savePath = "C:/development/intellij_community/spring_upload_files/" + storedFileName;
            boardFile.transferTo(new File(savePath));
            // board_file_table 저장 처리
            boardRepository.saveFile(boardFileDTO);
        }
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }
}
