<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring web mvc</title>
</head>
<body>
<h3>session 확인</h3>
session id : <c:out value="${sessionid }"/><br>
session 애트리뷰트 : <c:out value="${userid }"/><br>
<button onclick="location.href='./'">홈</button>
</body>
</html>