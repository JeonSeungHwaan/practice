<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1> fileUpload.jsp </h1>  

<form action="/file/fileUploadPro" method="post" enctype="multipart/form-data">
	작성자 : <input type="text" name="name" /> <br/>
	파일 : <input type="file" name="file" /> <br/>
	
	<input type="submit" value="파일 업로드" />
</form>  