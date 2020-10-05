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
<h2>공지사항</h2>
	<hr>
	<table border="1">
		<tr>
			<td>카테고리</td>
			<td>제목</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="n" items="${list }">
			<tr>
				<td>${n.code_name }</td>
				<td>${n.n_title }</td>
				<td>${n.n_regdate }</td>
				<td>${n.n_hit }</td>
			</tr>
	
		</c:forEach>
	</table>
</body>
</html>