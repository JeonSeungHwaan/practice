<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	$(function(){
		$("form").submit(function(){
			if($("#id").val() == ""){
				alert("아이디를 입력하세요.");
				$("#id").css("border", "1px solid red");
				return false;
			}
			
			if($("#pw").val() == ""){
				alert("비밀번호를 입력하세요.");
				$("#pw").css("border", "1px solid red");
				return false;
			}
		});
	});
</script>

<h1> login.jsp </h1>

<form action="/practice/member/loginPro" method="post">
	아이디 : <input type="text" name="id" id="id" /> <br/>
	비밀번호 : <input type="password" name="pw" id="pw" /> <br/>
			<input type="submit" value="로그인" />
</form>