<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Model.member"%>
<%
	member m =(member) session.getAttribute("U1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		<table align=center border=0>
			<tr>
				<td>帳號:
				<td><input type="text" name="user" value=<%=m.getUser() %>>
			<tr>
				<td>密碼:
				<td><input type="password" name="password" value=<%=m.getPassword() %>>
			<tr>
				<td>姓名:
				<td><input type="text" name="name" value=<%=m.getName() %>>	
			<tr>
				<td>電話:
				<td><input type="text" name="phone" value=<%=m.getPhone() %>>
			<tr>
				<td>學歷:<%=m.getStudent() %>
				<td><input type="radio" name="stud" value="碩士">碩士
					<input type="radio" name="stud" value="大學">大學
					<input type="radio" name="stud" value="高中">高中
					<input type="radio" name="stud" value="國中">國中
			<tr>
				<td colspan=2 align=center >
				<input type="reset" value="清除" >
				<input type="submit" value="更新存檔" >

		</table>
	</form>
</body>
</html>