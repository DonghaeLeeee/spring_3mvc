<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring web mvc</title>
</head>
<body>
	<h3>Model객체로 전달되는 애트리뷰트값 출력</h3>
	<hr>
	<h4>1. 값 1개 출력</h4>
	<c:out value="${message }" />
	<h4>2. 리스트 출력</h4>
	<c:forEach items="${list }" var="element">
	<c:out value="${element }"/> <br>
	</c:forEach>

</body>
</html>