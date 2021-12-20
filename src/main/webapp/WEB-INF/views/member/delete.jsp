<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	$(function(){
		$("form").submit(function(){
			if($("#pw").val() == ""){
				alert("비밀번호를 입력하세요.");
				$("#pw").css("border", "1px solid red");
				return false;
			}
		});
	});
</script>

<h1> delete.jsp </h1>

<c:if test="${sessionScope.memId != null}">
	<form action="/practice/member/deletePro" method="post">
		<input type="hidden" name="id" value="${sessionScope.memId}" />
		비밀번호 : <input type="password" name="pw" id="pw" />
		<input type="submit" value="회원탈퇴" />
	</form>
</c:if>