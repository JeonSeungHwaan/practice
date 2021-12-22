<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> delete.jsp </h1>

<form action="/practice/board/deletePro" method="post">
	<input type="hidden" name="bno" value="${bno}" />
	
	<c:if test="${sessionScope.memId == null}">
		비밀번호를 입력하세요
			<br/>
		<input type="password" name="pw" />
			<br/>
		<input type="submit" value="글 삭제" />
			<br/>
	</c:if>
	
	<c:if test="${sessionScope.memId != null}">
		<input type="hidden" name="member_id" value="${sessionScope.memId}" />
		글을 삭제하시겠습니까?
			<br/>
		<input type="submit" value="글 삭제" />
			<br/>
	</c:if>
	
	<input type="button" value="뒤로가기" onclick="history.go(-1);" />
	<input type="button" value="글 목록" onclick="window.location='/practice/board/list'" />
</form>
