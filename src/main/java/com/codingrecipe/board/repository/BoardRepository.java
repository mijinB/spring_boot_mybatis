package com.codingrecipe.board.repository;

import com.codingrecipe.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;

    public void save(BoardDTO boardDTO) {
        /**
         * resource > mapper > board-mapper.xml 참고
         * Board : namespace="Board"
         * save : query 문을 담고있는 태그. 태그의 id
         * boardDTO : query 로 보낼 data 가 있으면 보내는 것. 하나만 적을 수 있다. 두개 이상을 보내야 한다면 HashMap 같은 걸 정의해서 넘긴다면 가능하다.
         */
        sql.insert("Board.save", boardDTO);
    }
}
