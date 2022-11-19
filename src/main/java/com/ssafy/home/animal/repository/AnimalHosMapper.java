package com.ssafy.home.animal.repository;

import com.ssafy.home.animal.dto.AnimalHosDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalHosMapper {
    int insert(AnimalHosDTO animalHosDTO);
}
