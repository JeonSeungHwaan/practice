<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> deletePro.jsp </h1>

<c:if test="${result == 1}">
	<script>
		alert("탈퇴되었습니다.");
		window.location="/practice/security/logout";
	</script>
</c:if>

<c:if test="${result != 1}">
	<script>
		alert("비밀번호가 틀립니다.");
		history.go(-1);
	</script>
</c:if>