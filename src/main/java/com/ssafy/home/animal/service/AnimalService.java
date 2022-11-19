package com.ssafy.home.animal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.animal.dto.AnimalHosDTO;
import com.ssafy.home.animal.dto.AnimalPharDTO;
import com.ssafy.home.animal.dto.AptAnimalDTO;
import com.ssafy.home.animal.repository.AnimalHosMapper;
import com.ssafy.home.animal.repository.AnimalMapper;
import com.ssafy.home.animal.repository.AnimalPharmacyMapper;
import com.ssafy.home.apt.dto.HousedealinfoDTO;
import com.ssafy.home.apt.repository.AptMapper;
import com.ssafy.home.station.dto.AptStationDTO;

@Service
public class AnimalService {

	private final AnimalHosMapper animalHosDao;
	private final AnimalPharmacyMapper animalPharmacyMapper;
	private final AnimalMapper animalDao;
	private final AptMapper Aptdao;

	@Autowired
	public AnimalService(AnimalHosMapper animalHosDao, AnimalPharmacyMapper animalPharmacyMapper,
			AnimalMapper animalDao, AptMapper Aptdao) {
		this.animalHosDao = animalHosDao;
		this.animalPharmacyMapper = animalPharmacyMapper;
		this.animalDao = animalDao;
		this.Aptdao = Aptdao;
	}

	public int inputData(AnimalHosDTO animalHosDTO) {
		return animalHosDao.insert(animalHosDTO);
	}

	public int inputPharmacy(AnimalHosDTO animalHosDTO) {
		return animalPharmacyMapper.insert(animalHosDTO);
	}

	// 직선거리 공식 계산
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
		List<AnimalHosDTO> animalHosList;
		List<AnimalPharDTO> animalPharList;

		public Point(String aptName, int cnt, String dongName, String aptCode, String buildYear, String roadName,
				String jibun, String lat, String lng, List<AnimalHosDTO> animalHosList,
				List<AnimalPharDTO> animalPharList) {
			this.aptName = aptName;
			this.cnt = cnt;
			this.dongName = dongName;
			this.aptCode = aptCode;
			this.buildYear = buildYear;
			this.roadName = roadName;
			this.jibun = jibun;
			this.lat = lat;
			this.lng = lng;
			this.animalHosList = animalHosList;
			this.animalPharList = animalPharList;
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
	public List<AptAnimalDTO> threeAnimal(String dongName) {
		List<AptAnimalDTO> result = new ArrayList<AptAnimalDTO>();
		List<HousedealinfoDTO> tmpHouseList = Aptdao.selectTransportation(dongName);
		List<AnimalHosDTO> animalHosList = animalDao.selectAnimalHosList();
		List<AnimalPharDTO> animalPharList = animalDao.selectAnimalPharList();
		List<Point> arr = new ArrayList<>();
		// System.out.println(animalHosList);
		// double stationlat = Double.parseDouble(animalHosList.get(0).getLng());
		// System.out.println(stationlat);

		for (int i = 0; i < tmpHouseList.size(); i++) {
			// 아파트 매물 위치 표시
			double houselat = Double.parseDouble(tmpHouseList.get(i).getLat());
			double houselng = Double.parseDouble(tmpHouseList.get(i).getLng());

			// 전체 점수표
			int sum = 0;
			// 직선거리순 count
			int shortDisCnt = 0;
			// step1 : 동물병원
			List<AnimalHosDTO> shortDisAnimalHos = new ArrayList<AnimalHosDTO>();
			for (int j = 0; j < animalHosList.size(); j++) {
				double stationlat = Double.parseDouble(animalHosList.get(j).getLng());
				double stationlng = Double.parseDouble(animalHosList.get(j).getLat());
				double dis = distance(houselat, houselng, stationlat, stationlng);
				// System.out.println(dis);
				if (dis <= 500) {
					shortDisCnt++;
					shortDisAnimalHos.add(new AnimalHosDTO(animalHosList.get(j).getNo(), animalHosList.get(j).getName(),
							animalHosList.get(j).getStreet_addr(), animalHosList.get(j).getSite_addr(),
							animalHosList.get(j).getLat(), animalHosList.get(j).getLng(), dis));
				}
			}
//			System.out.println(
//					"동물병원 500m 이내 = 아파트 이름 : " + tmpHouseList.get(i).getApartmentName() + " 갯수 : " + shortDisCnt);
			// 지하철역 점수 계산
			sum = sum + shortDisCnt;

			// step2 : 버스정류소 역
			shortDisCnt = 0;
			List<AnimalPharDTO> shortDisAnmimalPhar = new ArrayList<>();
			for (int j = 0; j < animalPharList.size(); j++) {
				double bikelat = Double.parseDouble(animalPharList.get(j).getLng());
				double bikelng = Double.parseDouble(animalPharList.get(j).getLat());
				double dis = distance(houselat, houselng, bikelat, bikelng);
				if (dis <= 500) {
					shortDisCnt++;
					shortDisAnmimalPhar
							.add(new AnimalPharDTO(animalPharList.get(j).getNo(), animalPharList.get(j).getName(),
									animalPharList.get(j).getStreet_addr(), animalPharList.get(j).getSite_addr(),
									animalPharList.get(j).getLat(), animalPharList.get(j).getLng(), dis));
				}
			}
			sum = sum + shortDisCnt;

			arr.add(new Point(tmpHouseList.get(i).getApartmentName(), sum, tmpHouseList.get(i).getDongName(),
					tmpHouseList.get(i).getAptCode(), tmpHouseList.get(i).getBuildYear(),
					tmpHouseList.get(i).getRoadName(), tmpHouseList.get(i).getJibun(), tmpHouseList.get(i).getLat(),
					tmpHouseList.get(i).getLng(), shortDisAnimalHos, shortDisAnmimalPhar));
		}
		Collections.sort(arr);

		int k = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (k == 3)
				break;
			k++;
			System.out.println(arr.get(i).aptName + " " + arr.get(i).cnt);
			result.add(new AptAnimalDTO(arr.get(i).aptName, arr.get(i).dongName, arr.get(i).aptCode,
					arr.get(i).buildYear, arr.get(i).roadName, arr.get(i).jibun, arr.get(i).lat, arr.get(i).lng,
					arr.get(i).animalHosList, arr.get(i).animalPharList));
		}

		return result;
	}

}
