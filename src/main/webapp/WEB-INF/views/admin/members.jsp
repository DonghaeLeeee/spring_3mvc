<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberV3 List</title>
<style>
            /*  태그 요소를 선택하는 선택자 (selector) 를 지정합니다. */
            td {   /* 선택자 : td 태그 , 모든 td태그에 적용합니다. */
                border : 1px solid gray;
                text-align: center;
            }
            table {
                width: 70%;
                 /*  태그요소의 외부 여백(위,아래,왼,오)  */
                 margin-right: 5px;
                margin-left: 30px;
            }
            th {
                color: white;
                background-color: brown;
            }
            td,th{
                /* 태그요소의 내부 여백 (위,아래,왼,오) */
                padding-top: 5px;
                padding-bottom: 5px;
            }
            caption {  /* 글꼴 크기는 16px 기본 . 비율 : %, em */
                font-size: 1.2em;
            }
        </style>
</head>
<body>
<!-- request 객체의 애트리뷰트 가져오기. -->
<h3>회원 목록</h3>
 <table>
            <!-- 테이블의 제목 : 캡션 -->
            <tr> <!-- style 속성으로 디자인 프로퍼티 설정하기  -->
                <!-- td 대신에 제목 열 일때 th 사용  
                    : 가운데 정렬, 글꼴 굵게 적용
                -->
                <th style="width: 20%;">번호</th>
                <th style="width: 20%;">아이디</th>
                <th style="width: 30%;">이름</th>
                <th style="width:50%;">나이</th>
            </tr>
<c:forEach var="vo" items="${list}">  <!-- java의 for each 와 동일하다.  -->
            <tr> <!--  border 는 선의 굵기 모양 색상 설정  -->
                <td>${vo.name }</td>
                <td><a href="member?id=${vo.id }">${vo.id }</a></td>
                <td>${vo.email }</td>
                <td>${vo.age }</td>
                <!-- width 는 같은 열이면  같은 값이 적용-->
            </tr>
</c:forEach>
</table>            
<br>	
<a href="../">홈으로</a>  
</body>
</html>