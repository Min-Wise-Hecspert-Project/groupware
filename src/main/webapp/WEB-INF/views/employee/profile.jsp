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
					<div id="employeeProfile" class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                        

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
                       let content =`<div class="col">
		                                <div class="card shadow-sm">
		                                    <svg class="bd-placeholder-img card-img-top" width="20%" height="150" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">
		                                        ${'${result.employeeIdx}'}</text></svg>
		                                    <div class="card-body">
		                                    <p class="card-text">사원번호</p>
		                                    </div>
		                                </div>
		                            </div>
		                            <div class="col">
	                                <div class="card shadow-sm">
	                                    <svg class="bd-placeholder-img card-img-top" width="20%" height="150" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">
	                                        ${'${result.companyName}'}</text></svg>
	                                    <div class="card-body">
	                                    <p class="card-text">회사명</p>
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="col">
                                <div class="card shadow-sm">
                                    <svg class="bd-placeholder-img card-img-top" width="20%" height="150" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">
                                        ${'${result.employeeIdx}'}</text></svg>
                                    <div class="card-body">
                                    <p class="card-text">사원번호</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                            <div class="card shadow-sm">
                                <svg class="bd-placeholder-img card-img-top" width="20%" height="150" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">
                                    ${'${result.employeeIdx}'}</text></svg>
                                <div class="card-body">
                                <p class="card-text">사원번호</p>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                        <div class="card shadow-sm">
                            <svg class="bd-placeholder-img card-img-top" width="20%" height="150" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">
                                ${'${result.employeeIdx}'}</text></svg>
                            <div class="card-body">
                            <p class="card-text">사원번호</p>
                            </div>
                        </div>
                    </div>`;
                       $("#employeeProfile").append(content);
                    })
                    .catch(error => console.log('error', error));
            });
        </script>
	</body>

	</html>