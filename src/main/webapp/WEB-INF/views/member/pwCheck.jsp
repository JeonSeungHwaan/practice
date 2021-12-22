<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1> pwCheck.jsp </h1>

<form action="/practice/member/pwCheck" method="post">
	비밀번호를 입력하세요. <br/>
	<input type="hidden" name="id" value="${sessionScope.memId}" />
	<input type="password" name="pw" /> <br/>
	<input type="submit" value="확인" />
</form>