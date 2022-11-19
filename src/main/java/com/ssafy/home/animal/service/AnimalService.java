package com.ssafy.home.animal.service;

import com.ssafy.home.animal.dto.AnimalHosDTO;
import com.ssafy.home.animal.repository.AnimalHosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    private final AnimalHosMapper animalDao;

    @Autowired
    public AnimalService(AnimalHosMapper animalDao) {
        this.animalDao = animalDao;
    }

    public int inputData(AnimalHosDTO animalHosDTO){
        return animalDao.insert(animalHosDTO);
    }
}
