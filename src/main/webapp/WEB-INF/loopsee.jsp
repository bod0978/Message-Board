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
<table align=center border=0 width="400">
	<tr align="center">
		<td width="100">標題:
		
	<tr align="center">	
		<td><%=sb.getCount() %>
		<hr>
	<tr align="center">
		<td>作者:
		
	<tr align="center">	
		<td><%=sb.getName() %>
		<hr>
	<tr align="center">
		<td>文章內容:
		<hr>
	<tr >	
		<td><%=sb.getNote() %>
		<hr>	
	<tr>
		<td align=center><a href="../loop/view" style="text-decoration:none;">回上一頁</a>	
</table>
</body>
</html>