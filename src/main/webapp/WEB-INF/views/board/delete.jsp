<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1> delete.jsp </h1>

<form action="/practice/board/deletePro" method="post">
	<input type="hidden" name="bno" value="${bno}" />
	비밀번호를 입력하세요
		<br/>
	<input type="password" name="pw" />
		<br/>
	<input type="submit" value="글 삭제" />
		<br/>
	<input type="button" value="뒤로가기" onclick="history.go(-1);" />
	<input type="button" value="글 목록" onclick="window.location='/practice/board/list'" />
</form>
