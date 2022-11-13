package com.ssafy.home.bike.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.bike.service.BikeService;

@RestController
@RequestMapping("/")
public class BikeController {
	private final BikeService service;

	public BikeController(BikeService service) {
		this.service = service;
	}

	@GetMapping("/insert")
	public ResponseEntity<?> insert(){
		int result = service.inputBikeInfo();
		
		if(result == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
	}
}
