package com.ssafy.home.animal.controller;

import com.ssafy.home.animal.dto.AnimalHosDTO;
import com.ssafy.home.animal.service.AnimalService;
import com.ssafy.home.member.controller.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
@CrossOrigin(origins = "*")
public class AnimalController {
    private final AnimalService animalService;
    public static final Logger logger = LoggerFactory.getLogger(AnimalController.class);
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
    
    @GetMapping("/list")
	public ResponseEntity<?> selectList(@RequestParam String dongName){
		return new ResponseEntity<Object>(animalService.threeAnimal(dongName) , HttpStatus.ACCEPTED);
	}
    
}
