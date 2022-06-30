<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>게시판</title>
		<jsp:include page="../includes/head.jsp"></jsp:include>
	</head>

	<body>
		<jsp:include page="../includes/header.jsp"></jsp:include>
		<div class="container-fluid">
			<div class="row">
				<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
					<div
						class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
						<h1 class="h2">게시판</h1>
						<div class="btn-toolbar mb-2 mb-md-0">
							<div class="btn-group me-2">
								<button type="button" class="btn btn-sm btn-outline-secondary"
									data-action="remove">삭제</button>
								<button type="button" class="btn btn-sm btn-outline-secondary"
									data-action="modify">수정</button>
							</div>
						</div>
					</div>
					<div class="container-fluid">
						<div class="content">
							<div class="row align-items-start">
								<div id="boardTitle"></div>
								<div id="viewer"></div>		
							</div>
						</div>
					</div>
				</main>

			</div>
		</div>
		<script>
		
			$(function () {
				const boardIdx = `${boardIdx}`
				console.log(boardIdx);
				var formdata = new FormData();

				var requestOptions = {
					method: 'GET',
					redirect: 'follow'
				};

				fetch("http://localhost:8080/api/board/${boardIdx}", requestOptions)
					.then(response => response.json())
					.then(result => {

					 	console.log(result)
						$('#boardTitle').html(`<h2 class='col-md-6'>제목 : ${'${result.title}'}<h2><hr>`);
					 	const viewer = toastui.Editor.factory({
							el: document.querySelector('#viewer'),
							viewer: true,
							height: '500px',
							initialValue: result.content
						});
					})
					.catch(error => console.log('error', error));
				$(function () {
					$('button').on("click", function () {
						let action = $(this).data("action");
						if (action==="remove") {
							console.log("작성취소");
	
							var requestOptions = {
							  method: 'DELETE',
							  redirect: 'follow'
							};

							fetch("http://localhost:8080/api/board/"+boardIdx, requestOptions)
							  .then(response => response.text())
							  .then(result => {
								  console.log(result);
								  location.href="/board";
							  })				  
							  .catch(error => console.log('error', error));
						}
						if (action==="modify") {
							console.log("수정폼으로 이동");
							location.href = `/board/modify/${boardIdx}`;
						}
					});
					
				});
			});
		</script>
	</body>

	</html>