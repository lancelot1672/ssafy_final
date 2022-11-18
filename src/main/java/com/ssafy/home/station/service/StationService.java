package com.ssafy.home.station.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.apt.dto.HousedealinfoDTO;
import com.ssafy.home.apt.repository.AptMapper;
import com.ssafy.home.station.dto.BusDTO;
import com.ssafy.home.station.dto.StationDTO;
import com.ssafy.home.station.repository.StationMapper;

@Service
public class StationService {

	@Autowired
	private StationMapper stationDao;

	@Autowired
	private AptMapper Aptdao;

	// 거리 계산 공식
	private static double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515 * 1609.344;

		return dist; // 단위 meter
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	// radian(라디안)을 10진수로 변환
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	// 아파트와 점수표
	static class Point implements Comparable<Point> {
		String aptName;
		int cnt;

		public Point(String aptName, int cnt) {
			this.aptName = aptName;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point p) {
			if (p.cnt < cnt) {
				return -1;
			} else if (p.cnt > cnt) {
				return 1;
			}
			return 0;
		}

	}

	// 지하철
	public List<HousedealinfoDTO> threeTP(String dongName) {
		List<HousedealinfoDTO> result = new ArrayList<HousedealinfoDTO>();
		List<HousedealinfoDTO> tmpHouseList = Aptdao.selectTransportation(dongName);
		List<StationDTO> stationList = stationDao.selectStationList();
		List<BusDTO> busList = stationDao.selectBusList();
		// System.out.println(busList);
		List<Point> arr = new ArrayList<>();

		// 돌면서 위도경도 비교해서 1키로미터 이내에 있는 것들
		// 갯수 구하기
		for (int i = 0; i < tmpHouseList.size(); i++) {
			// 아파트 매물 위치 표시
			double houselat = Double.parseDouble(tmpHouseList.get(i).getLat());
			double houselng = Double.parseDouble(tmpHouseList.get(i).getLng());

			// 전체 점수표
			int sum = 0;
			// 직선거리순 count
			int shortDisCnt = 0;
			// step1 : 지하철역
			for (int j = 0; j < stationList.size(); j++) {
				double stationlat = Double.parseDouble(stationList.get(j).getLat());
				double stationlng = Double.parseDouble(stationList.get(j).getLng());
				double dis = distance(houselat, houselng, stationlat, stationlng);
				// System.out.println(dis);
				if (dis <= 1000) {
					shortDisCnt++;
				}
			}
			// 지하철역 점수 계산
			sum = sum + shortDisCnt * 3;

			// step2 : 버스정류소 역
			shortDisCnt = 0;
			for (int j = 0; j < busList.size(); j++) {
				double buslat = Double.parseDouble(busList.get(j).getYcode());
				double buslng = Double.parseDouble(busList.get(j).getXcode());
				double dis = distance(houselat, houselng, buslat, buslng);
				if (dis <= 500) {
					shortDisCnt++;
				}
			}
			sum = sum + shortDisCnt;

			// step3 : 따릉이

			arr.add(new Point(tmpHouseList.get(i).getApartmentName(), sum));

		}
		// 정렬하기
		Collections.sort(arr);

		// 뽑아주기
		int k = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (k == 3)
				break;
			k++;
			System.out.println(arr.get(i).aptName + " " + arr.get(i).cnt);
			result.add(new HousedealinfoDTO(arr.get(i).aptName, arr.get(i).cnt));
		}
		// 출력하기
		return result;
	}

}
