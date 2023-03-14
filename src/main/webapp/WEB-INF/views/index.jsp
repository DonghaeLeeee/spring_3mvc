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
<div style="width:100%;height:200px;">
	<img alt="" src="resources/image/mymain.png" style="width:100%;height:100%;object-fit:cover;">
</div>
<h3>INDEX</h3>
세션 애트리뷰트가 있을까요? session 애트리뷰트 : 
<c:out value="${userid }"/>,<c:out value="${username }"/>,<c:out value="${location }"/>
<br>
<hr>
<h4>Admin</h4>
<ul>
	<li><a href="members">회원리스트</a></li>
</ul>
<hr>
<h4>회원 서비스</h4>
<ul>
	<li><a href="join">회원가입</a></li>
	<li><a href="login">로그인</a> <a href="logout">로그아웃</a>
			<c:out value="${member.name }"/>님 환영합니다. </li>
	<li><a href="update">회원정보 수정</a></li>
	<li><a href="delete">회원탈퇴</a></li>
</ul>
<hr>
<h4>파라미터 처리 연습</h4>
<ul>
	<li><a href="hello1?search=seoul">search 라는 이름의 파라미터 1개 </a></li>
	<li><a href="hello2?year=2023&text=good">year,text 라는 이름의 파라미터 2개 </a></li>
	<li><a href="hello3?search=seoul&text=spring&field=month">search,text,field 라는 이름의 파라미터 3개 </a></li>
	<li><a href="hello4?id=twice&name=트와이스&email=abc@gmail.com&age=30">NewMember의 필드를 파라미터로 하는 예시(1) </a></li>
	<li><a href="hello5?id=twice&name=트와이스&email=abc@gmail.com&age=30">NewMember의 필드를 파라미터로 하는 예시(2) </a></li>
</ul>
<hr>
<h4>Model 애트리뷰트 연습</h4>
<ul>
	<li><a href="spring">단순 Model 연습</a></li>
	<li>
		<form action="spring" method="post">
			<input name="test"> <button>spring 제출</button>
		</form>
	</li>
		<li>
		<form action="spring2" method="post">
			<input name="test"> <button>spring2 제출</button>
		</form>
	</li>
	<li>
		<form action="modelAttr">
			<input placeholder="검색컬럼" value="${column }" name = "column">		
			<input placeholder="검색단어" value="${text }" name = "text">		
			<button>검색</button>
		</form>
	</li>
</ul>
<script type="text/javascript">
	if('${alert}'!='')
		alert('${alert}')
</script>
</body>
</html>
<!-- 
### 파라미터와 애트리뷰트

1. 파라미터 
: 기존방식은 request.getParameter("파라미터이름")
: 핸들러 메소드 인자로 매개변수로 선언하면 됩니다.
2. 애트리뷰트 
: 기존방식은 jsp화면에 값을 전달하기 위해 request.setAttribute("애트리뷰트이름",[Object값])
: 스프링 web mvc 에서는 애트리뷰트를 Model 타입의 객체를 생성해서 전달합니다.(메소드 매개변수로 선언)

3. 스프링 web mvc 에서는 애트리뷰트를 Model 타입은 redirect 할때도 애트리뷰트를 전달할 수 있습니다.

 -->
