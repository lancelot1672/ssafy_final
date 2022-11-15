package com.ssafy.home.apt.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssafy.home.apt.dto.BaseaddressDTO;
import com.ssafy.home.apt.dto.HousedealinfoDTO;

@Repository
public interface AptMapper {
	public List<BaseaddressDTO> selectSidoName();

	public List<BaseaddressDTO> selectGugunName(String sidoName);

	public List<BaseaddressDTO> selectDongName(String sidoName, String gugunName);

	public String selectDongcode(BaseaddressDTO base);

	public List<HousedealinfoDTO> selectList(String dongCode, int dealYear, int dealMonth,
			@Param("startRow") int startRow, @Param("count") int count);

	public int selectTotalCount(String dongCode, int dealYear, int dealMonth);

	public HousedealinfoDTO selectOne(long no);
}
