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
				<td>�b��:
				<td><input type="text" name="user" value=<%=m.getUser() %>>
			<tr>
				<td>�K�X:
				<td><input type="password" name="password" value=<%=m.getPassword() %>>
			<tr>
				<td>�m�W:
				<td><input type="text" name="name" value=<%=m.getName() %>>	
			<tr>
				<td>�q��:
				<td><input type="text" name="phone" value=<%=m.getPhone() %>>
			<tr>
				<td>�Ǿ�:<%=m.getStudent() %>
				<td><input type="radio" name="stud" value="�Ӥh">�Ӥh
					<input type="radio" name="stud" value="�j��">�j��
					<input type="radio" name="stud" value="����">����
					<input type="radio" name="stud" value="�ꤤ">�ꤤ
			<tr>
				<td colspan=2 align=center >
				<input type="reset" value="�M��" >
				<input type="submit" value="��s�s��" >

		</table>
	</form>
</body>
</html>