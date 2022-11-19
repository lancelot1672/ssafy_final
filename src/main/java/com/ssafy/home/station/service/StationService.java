package com.ssafy.home.station.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.apt.dto.HousedealinfoDTO;
import com.ssafy.home.apt.repository.AptMapper;
import com.ssafy.home.station.dto.AptStationDTO;
import com.ssafy.home.station.dto.BikeDTO;
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
		String dongName;
		String aptCode;
		String buildYear;
		String roadName;
		String jibun;
		String lat;
		String lng;
		List<StationDTO> stationList;
		List<BusDTO> busList;
		List<BikeDTO> bikeList;

		public Point(String aptName, int cnt, String dongName, String aptCode, String buildYear, String roadName,
				String jibun, String lat, String lng, List<StationDTO> stationList, List<BusDTO> busList,
				List<BikeDTO> bikeList) {
			this.aptName = aptName;
			this.cnt = cnt;
			this.dongName = dongName;
			this.aptCode = aptCode;
			this.buildYear = buildYear;
			this.roadName = roadName;
			this.jibun = jibun;
			this.lat = lat;
			this.lng = lng;
			this.stationList = stationList;
			this.busList = busList;
			this.bikeList = bikeList;
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

	// 3개 추천
	public List<AptStationDTO> threeTP(String dongName) {
		// 결과
		List<AptStationDTO> result = new ArrayList<AptStationDTO>();
		// 아파트
		List<HousedealinfoDTO> tmpHouseList = Aptdao.selectTransportation(dongName);
		List<StationDTO> stationList = stationDao.selectStationList();
		List<BusDTO> busList = stationDao.selectBusList();
		List<BikeDTO> bikeList = stationDao.selectBikeList();
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
			List<StationDTO> shortDisStation = new ArrayList<>();
			for (int j = 0; j < stationList.size(); j++) {
				double stationlat = Double.parseDouble(stationList.get(j).getLat());
				double stationlng = Double.parseDouble(stationList.get(j).getLng());
				double dis = distance(houselat, houselng, stationlat, stationlng);
				// System.out.println(dis);
				if (dis <= 500) {
					shortDisCnt++;
					shortDisStation.add(new StationDTO(stationList.get(j).getLine(), stationList.get(j).getName(),
							stationList.get(j).getCode(), stationList.get(j).getLat(), stationList.get(j).getLng(),
							dis));
				}
			}
			// System.out.println("지하철역 1000m 이내 = 아파트 이름 : " +
			// tmpHouseList.get(i).getApartmentName() + " 갯수 : "+ shortDisCnt);
			// 지하철역 점수 계산
			sum = sum + shortDisCnt * 5;

			// step2 : 버스정류소 역
			shortDisCnt = 0;
			List<BusDTO> shortDisBus = new ArrayList<>();
			for (int j = 0; j < busList.size(); j++) {
				double buslat = Double.parseDouble(busList.get(j).getYcode());
				double buslng = Double.parseDouble(busList.get(j).getXcode());
				double dis = distance(houselat, houselng, buslat, buslng);
				if (dis <= 100) {
					shortDisCnt++;
					shortDisBus.add(new BusDTO(busList.get(j).getStop_nm(), busList.get(j).getYcode(),
							busList.get(j).getStop_no(), busList.get(j).getXcode(), dis));
				}
			}
			sum = sum + shortDisCnt * 3;
			//System.out.println( "따릉이  100m 이내 = 아파트 이름 : " + tmpHouseList.get(i).getApartmentName() + " 갯수 : " + shortDisCnt);

			// step3 : 따릉이
			shortDisCnt = 0;
			List<BikeDTO> shortDisBike = new ArrayList<>();
			for (int j = 0; j < bikeList.size(); j++) {
				double bikelat = Double.parseDouble(bikeList.get(j).getLat());
				double bikelng = Double.parseDouble(bikeList.get(j).getLng());
				double dis = distance(houselat, houselng, bikelat, bikelng);
				if (dis <= 100) {
					shortDisCnt++;
					shortDisBike.add(new BikeDTO(bikeList.get(j).getRent_id(), bikeList.get(j).getRent_name(),
							bikeList.get(j).getAddress1(), bikeList.get(j).getAddress2(), bikeList.get(j).getLat(),
							bikeList.get(j).getLng(), dis));
				}
			}
			sum = sum + shortDisCnt * 1;

			arr.add(new Point(tmpHouseList.get(i).getApartmentName(), sum, tmpHouseList.get(i).getDongName(),
					tmpHouseList.get(i).getAptCode(), tmpHouseList.get(i).getBuildYear(),
					tmpHouseList.get(i).getRoadName(), tmpHouseList.get(i).getJibun(), tmpHouseList.get(i).getLat(),
					tmpHouseList.get(i).getLng(), shortDisStation, shortDisBus, shortDisBike));
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
			result.add(new AptStationDTO(arr.get(i).aptName, arr.get(i).dongName, arr.get(i).aptCode,
					arr.get(i).buildYear, arr.get(i).roadName, arr.get(i).jibun, arr.get(i).lat, arr.get(i).lng,
					arr.get(i).stationList, arr.get(i).busList, arr.get(i).bikeList

			));
		}
		// 출력하기
		return result;
	}

}
