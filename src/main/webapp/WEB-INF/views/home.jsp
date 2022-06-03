<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="includes/head.jsp"></jsp:include>
<title>ERP HOME</title>
</head>
<body>
  <jsp:include page="includes/header.jsp"></jsp:include>
  <div class="container-fluid">
    <div class="row">
      <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
        <div
          class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
          <h1 class="h2">Dashboard</h1>
          
        </div>


        <div class="content">
          <div class="row align-items-start">

			<div class="col-md-6">
			  	<jsp:include page="notice/gridView.jsp"></jsp:include>
			</div>
          

            <div class="col-md-6">
              	<jsp:include page="schedule/calendar.jsp"></jsp:include>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6" id="grid3">
          		<jsp:include page="board/gridView.jsp"></jsp:include>
            </div>
          </div>
        </div>
      </main>
    </div>
  </div>


  </body>

  </html>