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
							<button type="button" class="btn btn-sm btn-outline-secondary"
								data-action="remove">취소</button>
							<button type="button" class="btn btn-sm btn-outline-secondary"
								data-action="modify">작성</button>
						</div>
					</div>
				</div>
				<div class="container-fluid">
					<div class="content">
						<div class="row align-items-start">
							<input class="col-md-6 form-control m-3" id="notice_title" placeholder="공지사항 제목을 입력하세요"></input>
						</div>
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
		const noticeIdx = `${noticeIdx}`
		console.log(noticeIdx);
		var formdata = new FormData();

		var requestOptions = {
			method: 'GET',
			redirect: 'follow'
		};

		fetch("http://localhost:8080/api/notice/${noticeIdx}", requestOptions)
			.then(response => response.json())
			.then(result => {
				editor.setHTML(result.content);
				$('#notice_title').val(result.title)
			})
			.catch(error => console.log('error', error));


		editor.removeHook("addImageBlobHook");

		editor.addHook("addImageBlobHook", (blob, callback) => {
			console.log(blob);
			callback("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png", "imageURL");
		})

		$(function () {
			$('button').on("click", function () {
				let action = $(this).data("action");
				if (action === "remove") {
					console.log("삭제요청");
					history.back();
				}
				if (action === "modify") {
					console.log("업데이트 요청");
					let title = $("#notice_title").val();
					let content = editor.getHTML();

				
					let updateData =JSON.stringify({ 
						"noticeIdx": noticeIdx,
						"title": title,
						"content": content,
						"file": "없음!",
						"state":1
					})
					var myHeaders = new Headers();
				    myHeaders.append("Content-Type", "application/json");
					var requestOptions = {
						method: 'PUT',
						headers: myHeaders,
						body: updateData
					};

					fetch("http://localhost:8080/api/notice", requestOptions)
						.then(response => response.json())
						.then(result => {	
							console.log(result);
							location.href = "/notice/"+result?.noticeIdx;
						})
						.catch(error => console.log('error', error));
				}
			});

		});

	</script>
</body>

</html>