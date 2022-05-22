<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<th>no</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		
		<c:forEach items="${list }" var="notice">
		<tr>
			<td>1</td>
			<td><a href="${notice.noticeIdx} }">${notice.title }</a></td>
			<td>${notice.author }</td>
			<td>${notice.insDate }</td>
			<td>100000</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>