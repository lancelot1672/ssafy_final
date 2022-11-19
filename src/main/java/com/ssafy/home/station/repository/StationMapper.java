package com.ssafy.home.station.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.home.station.dto.BikeDTO;
import com.ssafy.home.station.dto.BusDTO;
import com.ssafy.home.station.dto.StationDTO;

@Repository
public interface StationMapper {
	public List<StationDTO> selectStationList();
	public List<BusDTO> selectBusList();
	public List<BikeDTO> selectBikeList();
}
