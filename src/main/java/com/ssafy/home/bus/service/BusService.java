package com.ssafy.home.bus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.bus.dto.BusDTO;
import com.ssafy.home.bus.repository.BusMapper;

@Service
public class BusService {

	private final BusMapper busDao;

	@Autowired
	public BusService(BusMapper busDao) {
		this.busDao = busDao;
	}

	public int inputBusInfo() {

		// List<BusDTO> list = BusUtil.execute(); -> 여기에서 insert값들 받아와서 파라미터 안받아줌
		List<BusDTO> list = new ArrayList<BusDTO>();
		int result = 1;
		for (int i = 0; i < 1000; i++) {
			result = busDao.insert(list.get(i));
		}
		return result;
	}
	
	public List<BusDTO> selectList(){
		return busDao.selectList();
	}

}
