<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.memo" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモ一覧</title>
</head>
<body>
<h2>メモ一覧</h2>
<hr>
<form action="MemoSearchServlet" method="">

<input type="submit" value="検索">
</form>
<hr>
<%
    // セッションから memoList を取得
    List<memo> memoList = (List<memo>) session.getAttribute("memoList");

    if (memoList == null || memoList.isEmpty()) {
%>
        <p>メモは登録されていません。</p>
<%
    } else {
        for (memo m : memoList) {//
%>
            <h3><%= m.getTitle() %></h3>
            <p><%= m.getText() %><%= m.getDay() %></p>
            <a href="MemoDelServlet?id=<%= m.getId() %>"
   onclick="return confirm('このメモを削除しますか？');">
   削除
</a>

<a href="MemoEdiServlet?id=<%= m.getId() %>">
    編集
</a>
            <hr>
<%
        }
    }
%>
<a href="MemoRegistrationServlet">メモ追加</a>
<a href="MemoMainServlet">メモ一覧へ</a>
<a href="WelcomeServlet">TOPへ</a>

</body>
</html>