<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1> update.jsp </h1>    

<form action="/practice/board/updatePro" method="post">
	<input type="hidden" name="bno" value="${testBoardDTO.bno}" />
	작성자 : <input type="text" name="writer" value="${testBoardDTO.writer}" /> <br/>
	제목 : <input type="text" name="title" value="${testBoardDTO.title}" /> <br/>
	내용 : <textarea rows="10" cols="20" name="content">${testBoardDTO.content}</textarea> <br/>
	비밀번호 : <input type="password" name="pw" /> <br/>
	<input type="submit" value="글 수정" />
</form>
