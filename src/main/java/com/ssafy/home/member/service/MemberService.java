package com.ssafy.home.member.service;

import com.ssafy.home.member.dto.MemberDto;
import com.ssafy.home.member.repository.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private SqlSession sqlSession;

    public int join(MemberDto memberDto) throws Exception {
        return sqlSession.getMapper(MemberMapper.class).insert(memberDto);
    }

    public MemberDto login(MemberDto memberDto) throws Exception {
        if (memberDto.getUserId() == null || memberDto.getUserPw() == null)
            return null;
        return sqlSession.getMapper(MemberMapper.class).login(memberDto);
    }

    public MemberDto userInfo(String userid) throws Exception {
        return sqlSession.getMapper(MemberMapper.class).userInfo(userid);
    }

    public int saveRefreshToken(String userid, String refreshToken) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userid", userid);
        map.put("token", refreshToken);
        int result = sqlSession.getMapper(MemberMapper.class).saveRefreshToken(map);

        return result;
    }

    public Object getRefreshToken(String userid) throws Exception {
        return sqlSession.getMapper(MemberMapper.class).getRefreshToken(userid);
    }

    public void deleRefreshToken(String userid) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userid", userid);
        map.put("token", null);
        sqlSession.getMapper(MemberMapper.class).deleteRefreshToken(map);
    }

}
