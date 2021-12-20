<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1> imgUpdate.jsp </h1>

<form action="/practice/member/imgUpdatePro" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${sessionScope.memId}" />
	<input type="file" name="save" /> <br/>
	<input type="submit" value="사진 변경" />
</form>