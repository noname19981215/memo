<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Memo" %>


<h2>メモ検索</h2>

<form action="MemoSearchUpServlet" method="post">

メモ検索欄:<br>
<textarea name="memo" rows="5" cols="40"></textarea><br><br><%-- ここの改行でPOST内に空白が入っていたため検索の際エラーが発生していた --%>

<input type="submit" value="検索">
</form>