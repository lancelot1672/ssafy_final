package com.ssafy.home.board;

import com.ssafy.home.board.repository.BoardMapper;
import com.ssafy.home.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardService boardService;
    @Test
    public void selectCountForGuguns(){
        // select count(*) from qna_board where gugun in ('종로구','용산구'); => 184
        List<String> guguns = Arrays.asList("종로구", "용산구");
        int count = boardMapper.getTotalCount2(guguns);

        System.out.println("count = " + count);

    }
    @Test
    public void selectBoardListForGuguns(){
        // select count(*) from qna_board where gugun in ('종로구','용산구'); => 184
        List<String> guguns = Arrays.asList("종로구", "용산구");
        Map<String, Object> resultMap =  boardService.makePage2(1, guguns);

        System.out.println("resultMap.toString() = " + resultMap.toString());

    }
}
