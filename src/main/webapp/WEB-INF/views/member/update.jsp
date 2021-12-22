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
			if($("#name").val() == ""){
				alert("이름을 입력하세요.");
				$("#name").css("border", "1px solid red");
				return false;
			}
			if($("#nickname").val() == ""){
				alert("닉네임을 입력하세요.");
				$("#nickname").css("border", "1px solid red");
				return false;
			}
		});
	});
</script>

<h1> update.jsp </h1>

<c:if test="${sessionScope.memId != null }">
	<form action="/practice/member/updatePro" method="post">
		<input type="hidden" name="id" value="${memberInfo.id}" />
		이름 : <input type="text" name="name" value="${memberInfo.name}" id="name" /> <br/>
		닉네임 : <input type="text" name="nickname" value="${memberInfo.nickname}" id="nickname" /> <br/>
		<input type="submit" value="정보수정" />
	</form> 
</c:if>