<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring web 회원가입</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/join.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/join.js"></script>
</head>
<body>
<div style="margin:auto;width:800px;padding:20px;">

	 <h3>회원 가입</h3>
<form action="join" method="post">
<table>
	<tr>
		<td>
			<label for="lblId">아이디</label>
		</td>
		<td id="join">
		<input type="text" id="lblId" name="id">
		</td>
	</tr>
	<tr>
		<td>
			<label for="lblName">이름</label>
		</td>
		<td id="join">
		<input type="text" id="lblName" name="name">
		</td>
	</tr>
	<tr>
		<td>
			<label for="lblPass">패스워드</label>
		</td>
		<td id="join">
		<input type="password" id="lblPass" name="password">
		</td>
	</tr>
	<tr>
		<td>
			<label for="lblEmail">이메일</label>
		</td>
		<td id="join">
		<input type="email" id="lblEmail" name="email">
		</td>
	</tr>
	<tr>
		<td>
			<label for="lblAge">나이</label>
		</td>
		<td id="join">
		<input type="number" id="lblAge" name="age">
		</td>
	</tr>
	<tr>
		<td>
			<label for="lblAddr">지역(주소)</label>
		</td>
		<td id="join">  <!-- 선택상자(콤보 박스) , 드롭다운 -->
			<select id="lblAddr" name="address">
				<option value="서울">서울</option>
				<option value="인천">인천</option>
				<option value="대전">대전</option>
				<option value="대구">대구</option>
				<option value="광주">광주</option>
				<option value="부산">부산</option>
				<option value="기타">기타</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			<label>성별</label>
		</td>
		<td>
		<!-- radio 버튼은 여러개 중 단일 선택. name 속성값이 같게하여
			 그룹화.
		 -->
			<input type="radio" name="gender" id="lblMale" value="M">
			<label for="lblMale">남성</label>
			<input type="radio" name="gender" id="lblFemale" value="F">
			<label for="lblFemale">여성</label>
			<input type="radio" name="gender" id="lblNo" checked="checked" value="U">
			<label for="lblNo">모름</label>
		</td>
	</tr>
	<tr>
		<td>
			<label>취미</label>
		</td>
		<td>  
			<!-- 체크박스는 다중 선택. -> name 속성값을 동일하게하여 선택된 것들을 배열로 처리 -->
			<input type="checkbox" id="lblFootball" name="hobby" value="축구">
			<label for="lblFootball">축구</label>
			<input type="checkbox" id="lblBaseball" checked="checked" name="hobby" value="야구">
			<label for="lblBaseball">야구</label>
			<input type="checkbox" id="lblRun" name="hobby" value="달리기">
			<label for="lblRun">달리기</label>
			<input type="checkbox" id="lblSwim" name="hobby" value="수영">
			<label for="lblSwim">수영</label>
		</td>
	</tr>
	<tr>
		<td colspan="2" id="join">
			<button onclick="func_join()" type="button">가입하기</button>     
			<button type="reset" >다시쓰기</button>
		</td>
	</tr>
</table>
</form>	
</div>
<script type="text/javascript">
const join = document.querySelector('#join')
join.disabled=true
</script>
</body>
</html>