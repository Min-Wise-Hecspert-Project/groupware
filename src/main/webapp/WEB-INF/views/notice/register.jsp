<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>공지사항 작성</title>
		<jsp:include page="../includes/head.jsp"></jsp:include>
	</head>

	<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">공지사항 작성</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<button type="button" class="btn btn-sm btn-outline-secondary" data-action="cancel">취소</button>
							<button type="button" class="btn btn-sm btn-outline-secondary" data-action="register">작성</button>
						</div>
					</div>
				</div>
				<div class="container-fluid">
					<div class="content">
						<div class="row align-items-start">
							<input class="col-md-6" id="notice_title" placeholder="공지사항 제목을 입력하세요"></input>
						</div>
						<div class="row align-items-start">
							<div class="col-md-12" id="editor"></div>
						</div>
						<div class="row align-items-start">
							<div class="col-md-12" id="editor2"></div>
						</div>
						<div class="row align-items-start">
							<div class="col-md-12" id="viewer"></div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
		

		<script>
			const editor = new toastui.Editor({
					el: document.querySelector('#editor'),
					initialEditType: 'wysiwyg',
					height: '500px'
			});
			const editor2 = new toastui.Editor({
				el: document.querySelector('#editor2'),
				viewer: true
			});
			editor2.isViewer();
			$(function () {
				$('button').on("click", function () {
					let action = $(this).data("action");
					if (action==="cancel") {
						console.log("작성취소");
					}
					if (action==="register") {
						console.log("요청보내기");
						let title = $("#notice_title").val();
						let content = editor.getHTML();
						editor2.setHTML(content,"ture");
						let viewer = $('#viewer').html(content);
						
						var formdata = new FormData();
						formdata.append("title", title);
						formdata.append("content", content);
						formdata.append("file", "없음!");
						formdata.append("employeeIdx", "1");
						formdata.append("state", "1");

						var requestOptions = {
						  method: 'POST',
						  body: formdata,
						  redirect: 'follow'
						};

						fetch("http://localhost:8080/api/notice", requestOptions)
						  .then(response => response.json())
						  .then(result => console.log(result))
						  .catch(error => console.log('error', error));	
					}
				});
				
			});
			editor.removeHook("addImageBlobHook");
				
			editor.addHook("addImageBlobHook", (blob, callback) =>{
				console.log(blob);
				callback("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png","imageURL");
			})
		
		</script>
	</body>

	</html>