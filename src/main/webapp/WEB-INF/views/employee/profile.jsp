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
					<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
						<h1 class="h2">사원 정보</h1>
					</div>
				
				</main>

			</div>
		</div>
        <script>
            $(function () {
                const employeeIdx = `${employeeIdx}`
                console.log(employeeIdx);
                var formdata = new FormData();
                var requestOptions = {
                method: 'GET',
                redirect: 'follow'
                };

                fetch("http://localhost:8080/api/employee/${employeeIdx}", requestOptions)
                    .then(response => response.json())
                    .then(result => {
                       console.log(result);
                    })
                    .catch(error => console.log('error', error));
            });
        </script>
	</body>

	</html>