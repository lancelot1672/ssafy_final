package com.ssafy.home.animal.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.home.animal.dto.AnimalHosDTO;
import com.ssafy.home.animal.dto.AnimalPharDTO;

@Repository
public interface AnimalMapper {
	List<AnimalHosDTO> selectAnimalHosList();
	List<AnimalPharDTO> selectAnimalPharList();
}
