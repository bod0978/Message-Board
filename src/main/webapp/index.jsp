<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<%
	session.invalidate();
%>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<form action="member/login" method="post" name=loginF>
	<table align="center" border="0">
		<tr>
			<td colspan=2 align=center><h3>登入頁面</h3>
		<tr>
			<td>帳號:
			<td><input type="text" name="user" >
		<tr>
			<td>密碼:
			<td><input type="password" name="password" >
		<tr>
			<td colspan=2 align=center >
			<input type="reset" value="清除" >
			<input type="button" value="登入" onClick="check()">&ensp;&ensp;
			<input type ="button" onclick="javascript:location.href='member/addmv'" value="會員註冊" />
	</table>
</form>

<script type="text/javascript">
	function check()
	{
		if(loginF.user.value=="")
			{
				alert("帳號不可空白");
				return ;
			}
		if(loginF.password.value=="")
			{
				alert("密碼不可空白");
				return ;
			}
		loginF.submit();
			
	}
	
</script>



</body>
</html>