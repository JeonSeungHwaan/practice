<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	$(document).ready(function(){
		$("#idCheck").click(function(){
			if($("#id").val() == ""){
				alert("아이디를 입력해주세요.");
			} else {
				$.ajax({
					type : "post" ,
					url : "/practice/member/idCheck" ,
					data : { id : $("#id").val() } ,
					success : function(data){
						check = parseInt(data);
						if(check == 1){
							$("#checkResult").html("<font color='red'>사용불가능</font>")
						} else {
							$("#checkResult").html("<font color='green'>사용가능</font>")
						}
					}
				});
			}
		});
		
		$("form").submit(function(){
			
			if($("#id").val() == ""){
				alert("아이디를 입력해주세요.");
				return false;
			}
			
			// label 안에 있는 값을 가져올 땐 .text()를 이용
			if($("#checkResult").text() == ""){
				alert("아이디 중복확인을 해주세요.");
				return false;
			}
			// label 안에 있는 값을 가져올 땐 .text()를 이용
			if($("#checkResult").text() == "사용불가능"){
				alert("다른아이디를 사용해주세요.");
				return false;
			}
			
			if($("#pw").val() == ""){
				alert("비밀번호를 입력하세요.");
				return false;
			}
			if($("#name").val() == ""){
				alert("이름을 입력하세요.");
				return false;
			}
			if($("#nickname").val() == ""){
				alert("닉네임을 입력하세요.");
				return false;
			}
			if($("#birth").val() == ""){
				alert("생일을 입력하세요.");
				return false;
			}
		});
	});
	
</script>

<h1> singUp.jsp </h1>

<form action="/practice/member/singUpPro" method="post" enctype="multipart/form-data">
	* 아이디 : <input type="text" name="id" id="id" />
			 <input type="button" value="중복확인" id="idCheck" />
			 <label id="checkResult"></label> <br/>
	* 비밀번호 : <input type="password" name="pw" id="pw" /> <br/>
	* 이름 : <input type="text" name="name" id="name" /> <br/>
	* 닉네임 : <input type="text" name="nickname" id="nickname" /> <br/>
	* 생년월일 : <input type="date" name="birth" id="birth" /> <br/>
	프로필 사진 : <input type="file" name="save" /> <br/>
		<input type="submit" value="회원가입" />
</form>