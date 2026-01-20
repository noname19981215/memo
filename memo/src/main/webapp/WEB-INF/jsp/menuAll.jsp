<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモアプリ</title>
</head>
<body>
<p>メモアプリへようこそ<c:out value="${sessionScope.userId}"/>さん</p>

<form action=MemoMainServlet method=get>
    <button type=submit>メモ一覧を見る</button>
</form>

<a href="WelcomeServlet">TOPへ</a>
</body>
</html>