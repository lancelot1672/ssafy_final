package com.ssafy.home.apt.controller;

import java.util.List;
import java.util.Map;

import com.ssafy.home.apt.dto.AptLikeDTO;
import com.ssafy.home.apt.dto.HousedealinfoDTO;
import com.ssafy.home.apt.service.AptLikeService;
import com.ssafy.home.member.controller.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.home.apt.dto.BaseaddressDTO;
import com.ssafy.home.apt.service.AptService;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*")
public class AptController {
	public static final Logger logger = LoggerFactory.getLogger(AptController.class);
	private final AptService aptService;
	private final AptLikeService aptLikeService;

	@Autowired
	public AptController(AptService aptService, AptLikeService aptLikeService) {
		this.aptService = aptService;
		this.aptLikeService = aptLikeService;
	}

	@GetMapping("/sidoName")
	public ResponseEntity<?> sidolist(){
		return new ResponseEntity<List<BaseaddressDTO>>(aptService.getSidoNames(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/gugunName")
	public ResponseEntity<?> gugunlist(@RequestParam String sidoName){
		return new ResponseEntity<List<BaseaddressDTO>>(aptService.getGugunNames(sidoName), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/dongName")
	public ResponseEntity<?> donglist(@RequestParam String sidoName, @RequestParam String gugunName){
		return new ResponseEntity<List<BaseaddressDTO>>(aptService.getDongNames(sidoName, gugunName), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/dongCode")
	public ResponseEntity<?> dongCode(@RequestParam(value="dongName") String dongName,@RequestParam(value="sidoName") String sidoName){
		BaseaddressDTO base = new BaseaddressDTO();
		base.setDongName(dongName);
		base.setSidoName(sidoName);
		
		String dongCode = aptService.getDongCode(base);
		return new ResponseEntity<String>(dongCode, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> HouseList(@RequestParam String dongCode, @RequestParam int dealYear,@RequestParam int dealMonth,@RequestParam(value="page", defaultValue = "1") int page){

		return new ResponseEntity<Map<String, Object>>(aptService.makePage(dongCode, dealYear, dealMonth, page), HttpStatus.ACCEPTED);
	}

	@PostMapping("/like")
	public ResponseEntity<?> like(@RequestBody AptLikeDTO aptLikeDTO){

		try {
			aptLikeService.like(aptLikeDTO);
			return new ResponseEntity<String>("likeSuccess", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/like/{no}")
	public ResponseEntity<?> unlike(@PathVariable long no){

		try {
			aptLikeService.unlike(no);
			return new ResponseEntity<String>("unlikeSuccess", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/search")
	public ResponseEntity<?> selectAllByAptName(@RequestBody HousedealinfoDTO housedealinfoDTO){
		//최근 3년간 아파트 이름과 동 이름가지고 데이터 검색.
		logger.info("{}",housedealinfoDTO);
		try {
			List<HousedealinfoDTO> list = aptService.getTotalAmountByDong(housedealinfoDTO);
			return new ResponseEntity<List<HousedealinfoDTO>>(list, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/average/gugun")
	public ResponseEntity<?> averageGugun(@RequestParam String gugun){
		try {
			long price = aptService.getTotalAmountByGugun(gugun);
			return new ResponseEntity<Long>(price, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
