package com.ssafy.home.bike.repository;

import org.springframework.stereotype.Repository;

import com.ssafy.home.bike.dto.BikeDTO;

@Repository
public interface BikeMapper {
	public int insert(BikeDTO bike);
}
