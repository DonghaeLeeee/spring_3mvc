<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키 저장 확인</h3>
<p>개발자 도구에서 쿠키를 확인해보세요.</p>
쿠키이름 search : ${cookie.search.value }	<!-- jstl을 이용한 쿠키 접근(cookie 객체) -->
<!-- 쿠키는 오늘 본 상품, 오늘 본 게시글 등등.. -->
<script type="text/javascript">
	console.log(document.cookie)	  
	//HTTP only 속성이 설정된 값은 자바스크립트에서 접근 못합니다.
	let cookies = document.cookie.split(";")
	
	for(let i = 0; i <5;i++) {
		console.log(cookies[i])
	}
</script>
</body>
</html>