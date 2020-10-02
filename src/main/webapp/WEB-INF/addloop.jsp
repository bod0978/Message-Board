<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="Model.member"%>
<!DOCTYPE html>
<%
	member m = (member)session.getAttribute("M");
%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="../loop/loopcheck" method="post">
	<table align=center border=0>
		<tr>
			<td colspan=2 align=center> 新增留言
		<tr>
			<td colspan=2>
			<hr>	
		<tr>
			<td>標題:
			<td><input type="text" name="count" >
		<tr>
			<td colspan=2>
			<hr>		
		<tr border=1>
			<td>作者:
			<td ><%=m.getName() %>
			<!--  td><input type="text" name="name"  value="顯示文字" disabled>-->
		<tr>
			<td colspan=2>
			<hr>		
		<tr>
			<td>內容:
			<td><textarea rows="8" cols="28" name="note" placeholder="請輸入內容....."></textarea>
		<tr>
			<td colspan=2 align=center>
			<input type="reset" value="清除" >
			<input type="submit" value="送出">
		<tr>
			<td colspan=2 align=center><a href="../loop/view" style="text-decoration:none;">回首頁</a>	
	
	</table>

</form>
</body>
</html>