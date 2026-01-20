<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモ追加</title>
</head>
<body>
<form action="MemoAddServlet"method="post">
タイトル:<input type="text" name="title"><br>
メモ:<input type="text" name="memo"><br>
日時:<input type="date" name="date"><br>
<input type="submit" value="メモを追加">
</form>

</body>
</html>