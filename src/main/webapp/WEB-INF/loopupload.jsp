<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="Dao.billDao"
    import="Model.bill"%>
<%
	bill sb = (bill) session.getAttribute("SB");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="../loop/updateok" method="post">
<table align=center border=0 width="400">
	<tr align="center">
		<td width="100">標題:123
		
	<tr align="center">	
		<td><input type="text" name="count" value=<%=sb.getCount() %>>
		<hr>
	<tr align="center">
		<td>作者:
		
	<tr align="center">	
		<td align="center"><input type="text" name="name" value=<%=sb.getName() %>>
		<hr>
	<tr align="center">
		<td>文章內容:
		<hr>
	<tr>	
		<td aling=center><textarea rows="10" cols="53" name="note"><%=sb.getNote() %></textarea>
		<hr>	
	<tr clospan=2>
		<td align=center><a href="../loop/rootview" style="text-decoration:none;">回上一頁</a>	
		&ensp;&ensp;<input type="submit" value="更新存檔">	
</table>
</form>
</body>
</html>