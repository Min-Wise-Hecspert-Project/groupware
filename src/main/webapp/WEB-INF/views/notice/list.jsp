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
					<h1 class="h2">Dashboard</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
							<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
						</div>
						<button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
							<span data-feather="calendar" class="align-text-bottom"></span>
							This week
						</button>
					</div>
				</div>
				<div class="container-fluid">
					<div class="content">
						<div class="row align-items-start">
							<jsp:include page="view.jsp"></jsp:include>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script>
		$(function () {
			let notice = $("#notice-grid")
			notice.removeClass("col-md-6");
			notice.addClass("col-md-12");
			let width = notice.width();
			noticeGrid.setWidth(width);
			$("#notice-grid").resize(function () { 
				notice = $("#notice-grid")
				let width = notice.width();
				noticeGrid.setWidth(width);
				console.log("active resize")
			});
		});
		
		
		
		
	</script>
</body>

</html>