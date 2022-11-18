package com.ssafy.home.bus.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.home.bus.dto.BusDTO;



@Repository
public interface BusMapper {

	public int insert(BusDTO bus);
	public List<BusDTO> selectList();

}
