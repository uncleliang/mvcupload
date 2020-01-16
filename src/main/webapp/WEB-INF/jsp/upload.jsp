<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传界面</title>
</head>
<body>
	<form action="uploadFile" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		文件名:<input type="text" name="name"><br>
		<input type="submit" value="确定上传">
	</form>
</body>
</html>