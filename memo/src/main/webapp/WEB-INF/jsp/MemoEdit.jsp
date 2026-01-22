<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.Memo" %>

<%
Memo m = (Memo) request.getAttribute("memo");
%>

<h2>メモ編集</h2>

<form action="MemoUpServlet" method="post">

<input type="hidden" name="id" value="<%= m.getId() %>">

タイトル:<br>
<input type="text" name="title"
       value="<%= m.getTitle() %>"><br><br>

メモ:<br>
<textarea name="memo" rows="5" cols="40">
<%= m.getText() %>
</textarea><br><br>

日時:<br>
<input type="date" name="date"
       value="<%= m.getDay() %>"><br><br>

<input type="submit" value="更新">
</form>