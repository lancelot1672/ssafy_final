package com.ssafy.home.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssafy.home.apt.dto.SidocodeDTO;
import com.ssafy.home.board.dto.BoardDTO;

@Repository
public interface BoardMapper {
	public int writeBoard(BoardDTO boardDto);
	public List<BoardDTO> selectList(@Param("start") int startRow, @Param("cnt") int count, @Param(value = "gugun") String gugun);
	public int getTotalCount(@Param("gugun") String gugun);
	public BoardDTO selectOne(int bno);
	public void updateHit(int bno); // 조회수
	public int modifyBoard(BoardDTO boardDto);
	public int deleteBoard(int bno);

	public int getTotalCount2(List<String> guguns);
	public List<BoardDTO> selectList2(@Param("start") int startRow, @Param("cnt") int count, List<String> guguns);
}
