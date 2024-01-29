/* detail.html과 연동 */

/* 댓글 구현 */
let replyObject = {
	// 함수 생성
	init: function(){
		$(".reply_btn").click(() => {
			this.insertReply(); // 객체 안에는 this를 꼭 넣어줘야 함. -> this : 클릭한 대상을 의미
		});
	},
	insertReply: function(){
		// alert("댓글 등록 요청");
		let boardId = $("#boardId").val();
		// document.getElementById(replyContent).value;
		let replyContent = $("#replyContent").val();
		
		// 댓글란이 비었을 경우, 등록이 되지 않게끔 설정
		if(replyContent == ""){
			alert("댓글을 작성해주세요.");
			$("#replyContent").focus();
			return false;
		} 
		
		let reply = {
			content: replyContent // content - 컨트롤러 넘겨주는 데이터
		}
		console.log(reply);
		
		var header = $("meta[name='_csrf_header']").attr('content');
		var token = $("meta[name='_csrf']").attr('content');
		
		$.ajax({
			type: "POST",
			url: "/reply/" + boardId,
			beforeSend: function(xhr){
		        xhr.setRequestHeader(header, token);
		    },
			data: JSON.stringify(reply), // 자바스크립트 객체를 문자화해서 json으로 바꿔줌
			contentType: "application/json; charset=utf-8"
		}).done(function(response){
			console.log(response);
			replyContent = "";
			location.href = "/board/" + boardId;
		}).fail(function(error){
			alert("에러 발생 : " + error);
		});
	},
	deleteReply: function(boardId, replyId){
		// alert("댓글 삭제 요청");
		
		var header = $("meta[name='_csrf_header']").attr('content');
		var token = $("meta[name='_csrf']").attr('content');
		
		$.ajax({
			type: "DELETE",
			url: "/reply/" + replyId,
			beforeSend: function(xhr){
		        xhr.setRequestHeader(header, token);
		    }
		}).done(function(response){
			console.log(response);
			location.href = "/board/" + boardId;
		}).fail(function(error){
			alert("에러 발생 : " + error);
		});
	}
}

replyObject.init(); // init() 함수 호출