<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result == 1}">
	<script>
		window.location="/practice/member/update"
	</script>
</c:if>

<c:if test="${result != 1}">
	<script>
		alert("비밀번호가 틀립니다.");
		history.go(-1);
	</script>
</c:if>