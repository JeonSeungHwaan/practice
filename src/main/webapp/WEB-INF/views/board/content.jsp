<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1> content.jsp </h1>

조회수 : ${testboardDTO.readcount} <br/>  
제목 : ${testboardDTO.title} <br/> 
작성자 : ${testboardDTO.writer} <br/>
내용 : ${testboardDTO.content}   

<br/>

<c:if test="${result == 1}">
	<input type="button" value="글 수정" onclick="window.location='/practice/board/update?bno=${testboardDTO.bno}&writer=${testboardDTO.writer}&title=${testboardDTO.title}&content=${testboardDTO.content}'" />
	<input type="button" value="글 삭제" onclick="window.location='/practice/board/delete?bno=${testboardDTO.bno}'" />
</c:if>

<c:if test="${testboardDTO.pw != null}">
	<input type="button" value="글 수정" onclick="window.location='/practice/board/update?bno=${testboardDTO.bno}&writer=${testboardDTO.writer}&title=${testboardDTO.title}&content=${testboardDTO.content}'" />
	<input type="button" value="글 삭제" onclick="window.location='/practice/board/delete?bno=${testboardDTO.bno}'" />
</c:if>

<input type="button" value="글 목록" onclick="window.location='/practice/board/list'" />