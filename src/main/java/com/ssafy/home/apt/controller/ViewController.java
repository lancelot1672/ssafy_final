package com.ssafy.home.apt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.home.apt.service.AptService;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@Autowired
	AptService aptService;
	
	@GetMapping("/houseRead")
	public ModelAndView houseRead(@RequestParam(value="apartmentName") String apartmentName, @RequestParam String floor, @RequestParam int dealYear, @RequestParam int dealMonth){
		System.out.println(apartmentName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("houseinfo", aptService.gethouseRead(apartmentName, floor, dealYear, dealMonth));
		System.out.println("여기"+aptService.gethouseRead(apartmentName, floor, dealYear, dealMonth));
		mv.setViewName("detail");
		
		return mv;
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
