<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<jsp:include page="../includes/head.jsp"></jsp:include>
	<title>Board</title>
</head>

<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-4">
							<div id="searchBar"></div>
							<button type="button" data-action="search" class="btn btn-sm btn-outline-secondary">검색</button>
							<button type="button" data-action="register" class="btn btn-sm btn-outline-secondary">글작성</button>
						</div>
					</div>
				</div>
				<div class="container-fluid">
					<div class="content">
						<div class="row align-items-start">
							<div class="col-md-12">
								<jsp:include page="gridView.jsp"></jsp:include>
							</div>
							
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script>
		$(function () {
			
			
			
			//넓이값 측정 후 변경
			searchBoolean = false;
			$('button').on("click", function () {
				let action = $(this).data("action");
				if (searchBoolean&&action==="search") {
					console.log("필터링 검색 요청 보내기");
					searchBoolean = !searchBoolean;
					searchBar = $('#searchBar')
                	if (!searchBar.find("input[name='keyword']").val()) {
						alert("키워드를 입력하세요");
						return false;
					}
					let keyword = searchBar.find("input[name='keyword']").val();
					
					let select1 = searchBar.find("select[name='option1']").find("option:selected").val();
					let select2 = searchBar.find("select[name='option2']").find("option:selected").val();
					console.log(`keyword`, keyword);
					console.log(`select1`, select1);
					console.log(`select2`, select2);
					let params;

					params = {
						title : keyword
					}

					if (select1==="title") {
						params = {
							title : keyword
						}
					}
					if (select1==="content") {
						params = {
							content : keyword
						}
					}
					if (select1==="writer") {
						params = {
							writer : keyword
						}
					}
					if (select1==="titleAndContent") {
						params = {
							title : keyword,
							content : keyword
						}
					}
					if (select1==="titleAndWriter") {
						params = {
							title : keyword,
							writer : keyword
						}
					}
					if (select1==="contentAndWriter") {
						params = {
							content : keyword,
							writer : keyword
						}
					}
					if (select1==="titleAndContentAndWriter") {
						params = {
							title : keyword,
							content : keyword,
							writer : keyword
						}
					}
					var requestOptions = {
							method: 'GET',
							redirect: 'follow'
					};
					const dataSource = {
							  api: {
							    readData: { url: `/api/board?${'${params}'}&sorting=${'${select2}'}`, method: 'GET', initParams: { param: 'param' } }
							  }
					};
					// 파리미터 적용 후 통신 요청
					boardGrid.readData(1,params);
				} //if end
				if (action==="search") {
					$(this).attr('type', "text");
					let searchBar = `
									<input class='col-md-6 form-control' type='text' name='keyword'></input>
									<select class='col form-select form-select-sm' name="option1">
										<option value="title">제목</option>
										<option value="content" >내용</option>
										<option value="writer" >작성자</option>
										<option value="titleAndContent" >제목&내용</option>
										<option value="titleAndWriter" >제목&작성자</option>
										<option value="contentAndWriter" >내용&작성자</option>
										<option value="titleAndContentAndWriter" >제목&내용&작성자</option>
									</select>
									<select class='col form-select form-select-sm' name="option2">
										<option value="1" >제목 오름차순</option>
										<option value="2" >제목 내림차순</option>
										<option value="3" >내용 오름차순</option>
										<option value="4" >내용 내림차순</option>
										<option value="5" >작성자 오름차순</option>
										<option value="6" >작성자 내림차순</option>
									</select>
									`;
					$('#searchBar').addClass("row");
					$('#searchBar').html(searchBar);
					searchBoolean = !searchBoolean;
				}
				if (action==="register") {
					location.href = "/board/register"
				}
			});
		});	
	</script>
</body>
</html>