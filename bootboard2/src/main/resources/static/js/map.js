/* main.html과 연동 */

/* jquery 환경 - 버튼 클릭 이벤트 */
$(function(){
	// var HOME_PATH = window.HOME_PATH || '.';

	var cityhall = new naver.maps.LatLng(37.5339677, 126.897079),
	    map = new naver.maps.Map('map', {
	        center: cityhall.destinationPoint(0, 500),
	        zoom: 17
	    }),
	    marker = new naver.maps.Marker({
	        map: map,
	        position: cityhall
	    });

	var contentString = [
	        '<div class="iw_inner">',
	        '   <h3>이레빌딩</h3>',
	        '   <p>서울특별시 영등포구 선유동2로 57 이레빌딩 | 서울특별시 영등포구 양평동4가 2<br />',
	        '       02-120 | 공공,사회기관 &gt; 특별,광역시청<br />',
	        '       <a href="http://www.seoul.go.kr" target="_blank">www.seoul.go.kr/</a>',
	        '   </p>',
	        '</div>'
	    ].join('');

	var infowindow = new naver.maps.InfoWindow({
	    content: contentString
	});

	naver.maps.Event.addListener(marker, "click", function(e) {
	    if (infowindow.getMap()) {
	        infowindow.close();
	    } else {
	        infowindow.open(map, marker);
	    }
	});

	infowindow.open(map, marker);
	
	$("#btn1").click(function(){
		// alert("test");
		
		// 요청방식(type), url, data, dataType, success, error
		$.ajax({	
			type: "GET",
			url: "https://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List?serviceKey=zsy2cxIsnAul6JnzOV1ul3h%2FKXxNtT7Xw7Q6BOieVjRXmFxmTjKs1S02jYe6mE8sRHEQ38e8sfupjwYKLKImsQ%3D%3D&pageNo=1&numOfRows=10&type=json",
			dataType: "json", // 받는 데이터는 json 유형임을 명시 필수
			success: function(data){
				console.log(data);
				
				// 배열 선언
				let itemArr = data.TsunamiShelter[1].row;
				    
				// 테이블 작성
				let value = "";  // tag + data
				for(let i=0; i<itemArr.length; i++){
					let item = itemArr[i];
					value += "<tr>" 
						   + "<td>" + item.id + "</td>" 
						   + "<td>" + item.sido_name + "</td>" 
						   + "<td>" + item.sigungu_name + "</td>" 
						   + "<td>" + item.remarks + "</td>" 
						   + "<td>" + item.shel_nm + "</td>" 
						   + "<td>" + item.address + "</td>" 
						   + "<td>" + item.lon + "</td>" 
						   + "<td>" + item.lat + "</td>" 
						   + "<td>" + item.shel_av + "</td>" 
						   + "<td>" + item.length + "</td>" 
						   + "<td>" + item.shel_div_type + "</td>" 
						   + "<td>" + item.seismic + "</td>" 
						   + "<td>" + item.height + "</td>" 
						   + "</tr>";
				}
				
				// 데이터 보내줄 곳 지정
				$("#result1 tbody").html(value);
			},
			error: function(error){
				alert("에러 발생 : " + error);
			}
		});
	});
});