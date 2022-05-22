<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/notice/member" method="post" name="notice_form">
	<input type="text" id="" name="title">
	<input type="text" id="" name="content">
	<input type="text" id="" name="file">
	<input type="button" value="등록" onclick="send_form()">
</form>

<script>

	function send_form(){
		employee_idx = ${session.getAttribute("employeeIdx")};
		title = document.querySelector("#title").value;
		content = document.querySelector("#content").value;
		file = document.querySelector("#file").value;
		
		let data = {
				'employee_idx' : employee_idx,
				'title' : title,
				'content' : content,
				'file' : file,
			};

			$.ajax({
				url: "/notice",
				type: 'POST',
				dataType : 'json',
				async: true,
				data: data,
				beforeSend: function(){
					$('.processing').show();
				},
				complete: function(){
				    $('.processing').hide();
				},
				success: function(result){
			 		location.href = `/notice/${'${result.notice_idx}'}`
				},
				error: function(request,status,error){
					alert("등록실패. focus로 처리해줘야함.!!");
				}
			});
			
	}
</script>
</body>
</html>