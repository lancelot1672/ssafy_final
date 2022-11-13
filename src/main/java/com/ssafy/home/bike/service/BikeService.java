package com.ssafy.home.bike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.bike.dto.BikeDTO;
import com.ssafy.home.bike.repository.BikeMapper;
import com.ssafy.home.util.BikeUtil;

@Service
public class BikeService {
	
	private final BikeMapper bikeDao;
	
	@Autowired
	public BikeService(BikeMapper bikeDao) {
		this.bikeDao = bikeDao;
	}
	
	public int inputBikeInfo() {
		
		List<BikeDTO> list = BikeUtil.execute();
		int result = 1;
		for(int i=0; i<1000; i++) {
			result = bikeDao.insert(list.get(i));
		}
		return result;
	}
}
