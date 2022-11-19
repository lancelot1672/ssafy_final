package com.ssafy.home.animal.controller;

import com.ssafy.home.animal.dto.AnimalHosDTO;
import com.ssafy.home.animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
@CrossOrigin(origins = "*")
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody AnimalHosDTO animalHosDTO){
        int result = animalService.inputData(animalHosDTO);

        if(result == 1){
            return new ResponseEntity<String>("success", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<String>("fail", HttpStatus.BAD_GATEWAY);
        }
    }
    @PostMapping("/pharmacy")
    public ResponseEntity<?> insertPharmacy(@RequestBody AnimalHosDTO animalHosDTO){
        int result = animalService.inputPharmacy(animalHosDTO);

        if(result == 1){
            return new ResponseEntity<String>("success", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<String>("fail", HttpStatus.BAD_GATEWAY);
        }
    }
}
