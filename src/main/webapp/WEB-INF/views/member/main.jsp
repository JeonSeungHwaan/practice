<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> member/main.jsp </h1>    

<h2> ${sessionScope.nickName}님 환영합니다. </h2>

<input type="button" value="로그아웃" onclick="window.location='/practice/security/logout'" />
<input type="button" value="회원정보" onclick="window.location='/practice/member/userInfo'" />
<input type="button" value="게시판" onclick="window.location='/practice/board/list'" />
