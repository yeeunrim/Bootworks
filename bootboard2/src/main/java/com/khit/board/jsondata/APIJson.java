package com.khit.board.jsondata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIJson {
	
	public static void main(String[] args) {
	
		try {
			// 지진 해일 대피소 데이터 테스트
			String serviceKey = "serviceKey=zsy2cxIsnAul6JnzOV1ul3h%2FKXxNtT7Xw7Q6BOieVjRXmFxmTjKs1S02jYe6mE8sRHEQ38e8sfupjwYKLKImsQ%3D%3D";
			String url = "https://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List?" 
							+ serviceKey + "&pageNo=1" + "&numOfRows=10" + "&type=json";
			
			// 데이터를 받기 위해서 URL 클래스이 객체 생성
			URL requestUrl = new URL(url);
			System.out.println("URL : " + url);
			
			// openConnection()을 이용한 연결 
			HttpURLConnection conn = (HttpURLConnection)requestUrl.openConnection();
			conn.setRequestMethod("GET"); // 대문자로 명시함
			
			// 응답 상태 코드 (ex. 404, 200, 500 ...)
			int status = conn.getResponseCode(); // 반환값이 int로 되어 있음
			System.out.println("응답 상태 코드 : " + status);
			
			// 버퍼 : 입출력속도 향상을 위해서 데이터를 일시적으로 메모리 영역에 모아두는 것
			// BufferedReader & BufferedWriter : 보조스트림 
			// 보조스트림을 사용하기 위해서는 기반스트림(생성자) 필요 -> InputStreamReader
			InputStreamReader isr = new InputStreamReader(conn.getInputStream()) ;
			BufferedReader br = new BufferedReader(isr);
			
			String responseText = "";
			String line; // 한 행에 있는 데이터
			while((line = br.readLine()) != null) {
				responseText += line;
			}
			System.out.println(responseText);
			
			br.close();        // 버퍼 종료
			conn.disconnect(); // 연결 종료
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
