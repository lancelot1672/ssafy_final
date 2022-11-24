package com.ssafy.home.member.repository;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.member.dto.MemberDto;

@Mapper
public interface MemberMapper {
    public int insert(MemberDto memberDto) throws SQLException;
    public int findById(String userId) throws SQLException;

    public MemberDto login(MemberDto memberDto) throws SQLException;
    public MemberDto userInfo(String userid) throws SQLException;
    public int saveRefreshToken(Map<String, String> map) throws SQLException;
    public Object getRefreshToken(String userid) throws SQLException;
    public void deleteRefreshToken(Map<String, String> map) throws SQLException;

}