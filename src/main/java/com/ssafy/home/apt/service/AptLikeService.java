package com.ssafy.home.apt.service;

import com.ssafy.home.apt.dto.AptLikeDTO;
import com.ssafy.home.apt.repository.AptLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AptLikeService {
    private final AptLikeMapper aptLikeDao;

    @Autowired
    public AptLikeService(AptLikeMapper aptLikeDao) {
        this.aptLikeDao = aptLikeDao;
    }

    public List<AptLikeDTO> getLikeList(String userId) throws Exception{
        return aptLikeDao.selectList(userId);
    }

    public int like(AptLikeDTO aptLikeDTO) throws Exception{
        return aptLikeDao.insert(aptLikeDTO);
    }
    public int unlike(long no) throws Exception{
        return aptLikeDao.delete(no);
    }
}
