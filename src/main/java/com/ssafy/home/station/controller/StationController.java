package com.ssafy.home.station.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.station.service.StationService;

@RestController
@RequestMapping("/station")
public class StationController {

	@Autowired
	private StationService sservice;
	
	@GetMapping("/list")
	public ResponseEntity<?> selectList(@RequestParam String dongName){
		return new ResponseEntity<Object>(sservice.threeTP(dongName) , HttpStatus.ACCEPTED);
	}
	
}
