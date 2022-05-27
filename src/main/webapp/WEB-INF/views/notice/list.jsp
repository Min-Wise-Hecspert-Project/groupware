<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<jsp:include page="../includes/head.jsp"></jsp:include>
	<title>ERP HOME</title>
</head>

<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<button type="button" data-action="search" class="btn btn-sm btn-outline-secondary">검색</button>
							<button type="button" data-action="register" class="btn btn-sm btn-outline-secondary">글작성</button>
						</div>
					</div>
				</div>
				<div class="container-fluid">
					<div class="content">
						<div class="row align-items-start">
							<jsp:include page="gridView.jsp"></jsp:include>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script>
		$(function () {
			//넓이값 측정 후 변경
			widthBoolean = true;

			$('button').on("click", function () {
				let action = $(this).data("action");
				if (action==="search") {
					action.html("<input type='text'>");
				}
				if (action==="register") {
					location.href = "/notice/register"
				}
			});
		});	
	</script>
</body>
</html>