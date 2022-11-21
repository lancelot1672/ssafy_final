package com.ssafy.home.apt.repository;

import com.ssafy.home.apt.dto.AptLikeDTO;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface AptLikeMapper {
    public List<AptLikeDTO> selectList(String userId) throws SQLException;
    public int insert(AptLikeDTO aptLikeDTO) throws SQLException;
    public int delete(long no) throws SQLException;
}
