package com.ssafy.home.board.repository;

import com.ssafy.home.board.dto.CommentDTO;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface CommentMapper {
    List<CommentDTO> selectList(int bno) throws SQLException;
    void insert(CommentDTO commentDTO);
}
