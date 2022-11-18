package com.ssafy.home.bus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.bus.service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController {

	private final BusService service;

	public BusController(BusService service) {
		this.service = service;
	}
	
	@GetMapping("/insert")
	public ResponseEntity<?> insert(){
		int result = service.inputBusInfo();

		if(result == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> test(){
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> selectList(){
		return new ResponseEntity<Object>(service.selectList(),  HttpStatus.ACCEPTED);
	}
	
}
