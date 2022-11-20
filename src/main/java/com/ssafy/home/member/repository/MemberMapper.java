package com.ssafy.home.member.repository;

import com.ssafy.home.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.Map;

@Mapper
public interface MemberMapper {
    public int insert(MemberDto memberDto) throws SQLException;
    public MemberDto login(MemberDto memberDto) throws SQLException;
    public MemberDto userInfo(String userid) throws SQLException;
    public int saveRefreshToken(Map<String, String> map) throws SQLException;
    public Object getRefreshToken(String userid) throws SQLException;
    public void deleteRefreshToken(Map<String, String> map) throws SQLException;

}