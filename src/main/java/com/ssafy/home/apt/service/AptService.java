package com.ssafy.home.apt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.apt.dto.BaseaddressDTO;
import com.ssafy.home.apt.dto.HousedealinfoDTO;
import com.ssafy.home.apt.repository.AptMapper;

@Service
public class AptService {
	
	private static final int COUNT_PER_PAGE = 10;
	
	private final AptMapper dao;
	
	@Autowired
	public AptService(AptMapper dao) {
		this.dao = dao;
	}

	public List<BaseaddressDTO> getSidoNames() {
		System.out.println("test" + dao.selectSidoName());
        return dao.selectSidoName();
    }
	
	public List<BaseaddressDTO> getGugunNames(String sidoName) {
		return dao.selectGugunName(sidoName);
	}
	
	public List<BaseaddressDTO> getDongNames(String sidoName, String gugunName) {
		return dao.selectDongName(sidoName, gugunName);
	}
	
	public String getDongCode(BaseaddressDTO base) {
		return dao.selectDongcode(base);
	}
	
	public Map<String, Object> makePage(String dongCode,int dealYear,int dealMonth, int page) { // 현재 페이지
		/// 총게시글 수 구하기
		int totalCount = dao.selectTotalCount(dongCode, dealYear, dealMonth); // 총게시글 수
		int totalPage = totalCount / COUNT_PER_PAGE; // 55 / 10 = 5
		if (totalCount % COUNT_PER_PAGE > 0) // 55 % 10 = 3이면 페이지 하나 더 필요함
			totalPage++;
		/// 
		int startPage = (page - 1) / 10 * 10 + 1; // 1의 자리가 떨어진다./10 * 10하면 1의 자리가 떨어져 나가서 11, 12, 13 .... -> 10 되버림
		int endPage = startPage + 9; // 시작이 11이면 화면 하단 끝페이지는 20으로 맞춰놨음.
		if (endPage > totalPage)
			endPage = totalPage;
		int startRow = (page - 1) * COUNT_PER_PAGE; // (1-1)*10=0, (2-1)* 10=10, (3-1)*10=20
		List<HousedealinfoDTO> boardList = dao.selectList(dongCode, dealYear, dealMonth, startRow, COUNT_PER_PAGE);
		//////////////// 페이지에 보여줄 모든 데이터 확보 완료//////////////////////////
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("startPage", startPage);
		result.put("endPage", endPage);
		result.put("currPage", page);
		result.put("totalPage", totalPage);
		result.put("boardList", boardList);
		return result;
	}

	public HousedealinfoDTO gethouseRead(String apartmentName, String floor, int dealYear,int dealMonth){
		return dao.selectRead(apartmentName, floor, dealYear, dealMonth);
	}
	
}
