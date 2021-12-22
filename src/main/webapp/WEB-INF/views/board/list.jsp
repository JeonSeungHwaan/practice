<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1> list.jsp </h1>    

<c:forEach items = "${list}" var = "testboardDTO">
	${testboardDTO.bno} |
	작성자 : ${testboardDTO.writer} |
	제목 : <a href="/practice/board/readcount?bno=${testboardDTO.bno}">${testboardDTO.title}</a> |
	조회수 : ${testboardDTO.readcount} |
	작성날짜 : <fmt:formatDate value="${testboardDTO.regdate}" type="both" dateStyle="short" />
	<br/>
</c:forEach>

<input type="button" value="글 작성" onclick="window.location='/practice/board/write'"/>

<c:if  test="${sessionScope.memId != null}">
	<input type="button" value="메인화면" onclick="window.location='/practice/member/main'"/>
</c:if>

<c:if  test="${sessionScope.memId == null}">
	<input type="button" value="메인화면" onclick="window.location='/practice/member/all'"/>
</c:if>
