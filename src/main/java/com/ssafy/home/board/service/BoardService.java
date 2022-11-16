package com.ssafy.home.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.board.dto.BoardDTO;
import com.ssafy.home.board.repository.BoardMapper;

@Service
public class BoardService {

	private static final int COUNT_PER_PAGE = 10;
	@Autowired
	private BoardMapper dao;

	// list 페이지
	public Map<String, Object> makePage(int page, String gugun) { // 현재 페이지
		/// 총게시글 수 구하기
		int totalCount = dao.getTotalCount(gugun); // 총게시글 수
		int totalPage = totalCount / COUNT_PER_PAGE; // 55 / 10 = 5
		if (totalCount % COUNT_PER_PAGE > 0) // 55 % 10 = 3이면 페이지 하나 더 필요함
			totalPage++;
		///
		int startPage = (page - 1) / 10 * 10 + 1; // 1의 자리가 떨어진다./10 * 10하면 1의 자리가 떨어져 나가서 11, 12, 13 .... -> 10 되버림
		int endPage = startPage + 9; // 시작이 11이면 화면 하단 끝페이지는 20으로 맞춰놨음.
		if (endPage > totalPage)
			endPage = totalPage;
		int startRow = (page - 1) * COUNT_PER_PAGE; // (1-1)*10=0, (2-1)* 10=10, (3-1)*10=20
		List<BoardDTO> boardList = dao.selectList(startRow, COUNT_PER_PAGE, gugun);
		//////////////// 페이지에 보여줄 모든 데이터 확보 완료//////////////////////////
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("startPage", startPage);
		result.put("endPage", endPage);
		result.put("currPage", page);
		result.put("totalPage", totalPage);
		result.put("boardList", boardList);
		return result;
	}

	// 글쓰기
	public boolean writeBoard(BoardDTO board) {
		if (board == null || board.getTitle() == null || board.getTitle().length() == 0 || board.getUser_id() == null
				|| board.getUser_id().length() == 0)
			return false;
		if (dao.writeBoard(board) == 1)
			return true;
		return false;
	}

	// 글 상세보기
	public BoardDTO selectOne(int bno) {
		BoardDTO board = dao.selectOne(bno);
		dao.updateHit(bno);
		return dao.selectOne(bno);
	}

	// 글 수정
	public int modifyBoard(BoardDTO board) {
		return dao.modifyBoard(board);
	}

	// 글 삭제
	public int deleteBoard(int bno) {
		return dao.deleteBoard(bno);
	}

}
