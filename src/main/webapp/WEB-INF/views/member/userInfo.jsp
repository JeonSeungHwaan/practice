<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1> userInfo.jsp </h1>

<img src="/practice/resources/member/img/${memberInfo.img}" width="100" /> <br/>
<input type="button" value="프로필 사진 변경" onclick="window.location='/practice/member/imgUpdate'" />
<br/>
아이디 : ${memberInfo.id} <br/>
비밀번호 : ${memberInfo.pw} <br/>
이름 : ${memberInfo.name} <br/>
닉네임 : ${memberInfo.nickname} <br/>
생년월일 : <fmt:formatDate value="${memberInfo.birth}" type="date" /> <br/>
가입날짜 : <fmt:formatDate value="${memberInfo.regdate}" type="date" /> <br/>

<input type="button" value="정보 수정" onclick="window.location='/practice/member/update'" />
<input type="button" value="회원 탈퇴" onclick="window.location='/practice/member/delete'" />