package com.ssafy.home.util;

import com.google.gson.*;
//import com.ssafy.home.bike.dto.BikeDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AnimalUtil {
//	public static void main(String[] args) {
//		List<BikeDTO> list = execute();
//		System.out.println(list.size());
//	}
//
//	public static List<BikeDTO> execute() {
//		StringBuilder apiURL = new StringBuilder(
//				"http://openapi.seoul.go.kr:8088/487965454f6c616e37304b46496f4c/json/tbCycleStationInfo/1/1000/");
//
//		System.out.println(apiURL.toString());
//		String responseBody = get(apiURL.toString());
//		//System.out.println(responseBody);
//
//		Gson gson = new Gson();
//		JsonParser parser = new JsonParser();
//		JsonElement element = parser.parse(responseBody);
//		JsonObject body = element.getAsJsonObject().get("stationInfo").getAsJsonObject();
//
//		JsonArray row = body.getAsJsonObject().get("row").getAsJsonArray();
//		System.out.println(row.toString());
//		List<BikeDTO> list = new ArrayList<>();
//		for(int i=0; i<1000; i++) {
//			BikeDTO bike = new BikeDTO();
//			JsonObject bikeInfo = (JsonObject) row.get(i);
////			System.out.println(bikeInfo.toString());
//			String rentId = bikeInfo.get("RENT_NO").toString().replace("\"", "");
//			String location = bikeInfo.get("STA_LOC").toString().replace("\"", "");
//			String rentName = bikeInfo.get("RENT_NM").toString().replace("\"", "");
//			String address1 = bikeInfo.get("STA_ADD1").toString().replace("\"", "");
//			String address2 = bikeInfo.get("STA_ADD2").toString().replace("\"", "");
//			String lat = bikeInfo.get("STA_LAT").toString().replace("\"", "");
//			String lng = bikeInfo.get("STA_LONG").toString().replace("\"", "");
//			
//			bike.setRentId(Integer.parseInt(rentId));
//			bike.setLocation(location);
//			bike.setRentName(rentName);
//			bike.setAddress1(address1);
//			bike.setAddress2(address2);
//			bike.setLat(lat);
//			bike.setLng(lng);
//			
//			list.add(bike);
//		}
//		System.out.println(list.size());
//		return list;
//	}

	private static String get(String apiUrl) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			//  타입 설정
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 오류 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}
}
