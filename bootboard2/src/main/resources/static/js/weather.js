/* 날씨 정보 */

// 날짜를 변수화
const date = new Date();
console.log(date);
let  year = date.getFullYear();        // 2024
let month = '0' + date.getMonth() + 1; // 011
let day = '0' + date.getDate();        // 025
	
month = month.substring(1);            // substring(인덱스) 인덱스부터 끝까지 추출
day = day.substring(1);

let today = year + month + day;        // 20240125
	    
$.ajax({
	type: "GET",
	url: "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey=zsy2cxIsnAul6JnzOV1ul3h%2FKXxNtT7Xw7Q6BOieVjRXmFxmTjKs1S02jYe6mE8sRHEQ38e8sfupjwYKLKImsQ%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date=" 
      + today + "&base_time=0600&nx=55&ny=127",
  	success: function(data){
		  let T1H = data.response.body.items.item[3];
      	  let REH = data.response.body.items.item[1];     
      	  let WSD = data.response.body.items.item[7];
      	  let maincontent = "Today's Weather | " +  year + "." + month + "." + day;
      	  let content = "🌡 : ️" + T1H.obsrValue + "˚C 💧 : " + REH.obsrValue + "% 💨 : " + WSD.obsrValue + "m/s";
      	  
      	  $('.today').text(maincontent);
      	  $('.result').text(content);
    },
    error: function(error){
		console.log(error);
	}
});