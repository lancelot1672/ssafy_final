package com.ssafy.home.apt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.home.apt.dto.HousedealinfoDTO;
import com.ssafy.home.apt.service.AptService;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@Autowired
	AptService aptService;
	
	@GetMapping("/houseRead")
	public ResponseEntity<HousedealinfoDTO> houseRead(long no){
		return new ResponseEntity<HousedealinfoDTO>(aptService.gethouseRead(no), HttpStatus.ACCEPTED);
	}
	@GetMapping("/join")
	public String signup() {
		return "joinForm";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
