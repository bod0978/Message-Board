<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="Model.bill"%>
<!DOCTYPE html>
<%
	bill b = (bill) session.getAttribute("B");
%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="../loop/loopok" method="post">
	<table align=center broder=1>
		<tr>
			<td colspan=2> 留言訊息  確定是否送出?
			<hr>
		<tr>
			<td>標題:
			<td><%=b.getCount() %>
			<hr>
		<tr>
			<td>作者:
			<td><%=b.getName() %>
			<hr>
		<tr>
			<td>內容:
			<td><%=b.getNote() %>
			<hr>
		<tr>
			<td colspan=2 align=center>
			<a href="../loop/view" style="text-decoration:none;">取消
			<input type="submit" value="確定留言">
	</table>

</form>

</body>
</html>