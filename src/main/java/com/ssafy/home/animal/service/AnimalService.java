package com.ssafy.home.animal.service;

import com.ssafy.home.animal.dto.AnimalHosDTO;
import com.ssafy.home.animal.repository.AnimalHosMapper;
import com.ssafy.home.animal.repository.AnimalPharmacyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    private final AnimalHosMapper animalDao;
    private final AnimalPharmacyMapper animalPharmacyMapper;

    @Autowired
    public AnimalService(AnimalHosMapper animalDao, AnimalPharmacyMapper animalPharmacyMapper) {
        this.animalDao = animalDao;
        this.animalPharmacyMapper = animalPharmacyMapper;
    }

    public int inputData(AnimalHosDTO animalHosDTO){
        return animalDao.insert(animalHosDTO);
    }
    public int inputPharmacy(AnimalHosDTO animalHosDTO){
        return animalPharmacyMapper.insert(animalHosDTO);
    }
}
