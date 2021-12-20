<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> singUpPro.jsp </h1>

<c:if test="${result == 1}">
	<script>
		alert("가입되었습니다.");
		window.location = "/practice/member/login";
	</script>
</c:if>