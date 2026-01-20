<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<form action="RegistrationServlet" method="post">
    <p>ユーザーID: <input type="text" name="userId"></p>
    <p>パスワード: <input type="password" name="pass"></p>
    <p>メール: <input type="text" name="mail"></p>
    <p>名前: <input type="text" name="name"></p>
    <p>年齢: <input type="number" name="age"></p>

    <input type="submit" value="登録">
</form>

</body>
</html>