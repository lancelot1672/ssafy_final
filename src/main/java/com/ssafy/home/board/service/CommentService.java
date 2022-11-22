package com.ssafy.home.board.service;

import com.ssafy.home.board.dto.CommentDTO;
import com.ssafy.home.board.repository.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentMapper commentDao;

    @Autowired
    public CommentService(CommentMapper commentDao) {
        this.commentDao = commentDao;
    }

    public List<CommentDTO> getList(int bno) throws Exception{
        return commentDao.selectList(bno);
    }
    public void writeComment(CommentDTO commentDTO) throws Exception{
        commentDao.insert(commentDTO);
    }
}
