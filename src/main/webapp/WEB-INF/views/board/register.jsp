<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시판 작성</title>
	<jsp:include page="../includes/head.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">게시판 작성</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<button type="button" class="btn btn-sm btn-outline-secondary"
								data-action="cancel">취소</button>
							<button type="button" class="btn btn-sm btn-outline-secondary"
								data-action="register">작성</button>
						</div>
					</div>
				</div>
				<div class="container-fluid">
					<div class="content">
						<div class="row align-items-start form-group">
							<input class="col-md-3 form-control m-3" id="board_title" placeholder="게시판 제목을 입력하세요"></input>
						</div>
						<div class="row form-group">
							<div class="col-md-12" id="editor"></div>
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
		$(function () {
			$('button').on("click", function () {
				let action = $(this).data("action");
				if (action === "cancel") {
					console.log("작성취소");
				}
				if (action === "register") {
					console.log("요청보내기");
					let title = $("#board_title").val();
					let content = editor.getHTML();

		
					
					let registerData =JSON.stringify({ 
						"title": title,
						"content": content,
						"file": "없음!",
						"state":1
					})
					var myHeaders = new Headers();
				    myHeaders.append("Content-Type", "application/json");
					var requestOptions = {
						method: 'POST',
						headers: myHeaders,
						body: registerData
					};
					
					

					fetch("http://localhost:8080/api/board/register", requestOptions)
						.then(response => response.json())
						.then(result => {	
							console.log(result);
							location.href = "/board";
						})
						.catch(error => console.log('error', error));
				}
			});

		});
		editor.removeHook("addImageBlobHook");

		editor.addHook("addImageBlobHook", (blob, callback) => {
			
	

			var formdata = new FormData();
			formdata.append("uploadFile", blob);

			var requestOptions = {
			  method: 'POST',
			  body: formdata,
			  redirect: 'follow'
			};

			fetch("http://localhost:8080/upload/uploadAjaxAction", requestOptions)
			  .then(response => response.json())
			  .then(result => {
 				  let fileUrl = "http://localhost:8080/upload/display?fileName="+result[0].uploadpath+"/"+result[0].uuid+"_"+result[0].fileName;
				  
				  console.log('fileUrl', fileUrl);
				  callback(fileUrl.replace(new RegExp(/\\/g), "/"), "imageURL");
			  })
			  .catch(error => console.log('error', error));
			
			
		})

	</script>
</body>

</html>