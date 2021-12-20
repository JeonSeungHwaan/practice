<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> updatePro.jsp </h1>    

<c:if test="${result == 1}">
	<script>
		alert("수정 완료");
		window.location="/practice/board/content?bno=${testBoardDTO.bno}";
	</script>
</c:if>

<c:if test="${result != 1}">
	<script>
		alert("비밀번호를 확인하세요");
		history.go(-1);
	</script>
</c:if>