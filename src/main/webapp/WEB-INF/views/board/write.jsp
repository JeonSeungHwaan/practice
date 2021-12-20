<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> write.jsp </h1>   

<form action = "/practice/board/writePro" method = "post">
	<c:if test="${sessionScope.memId != null}">
		작성자 : ${sessionScope.nickName} <input type="hidden" name="writer" value="${sessionScope.nickName}" /> <br/>
	</c:if>
	
	<c:if test="${sessionScope.memId == null}">
		작성자 : <input type="text" name="writer" /> <br/>
	</c:if>
	
	제목 : <input type="text" name="title" /> <br/>
	내용 : <textarea rows="10" cols="20" name="content"></textarea> <br/>
	비밀번호 : <input type="password" name="pw" /> <br/>
	
	<input type="submit" value="글 작성" />
</form> 