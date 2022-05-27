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
							<div class="col-md-12" id="editor"></div>
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
			$(function () {
				$('button').on("click", function () {
					let action = $(this).data("action");
					if (action==="cancel") {
						console.log("작성취소");
					}
					if (action==="register") {
						console.log("요청보내기");
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