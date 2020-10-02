<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="addm" method="post" name=loginF>
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
			<td>姓名:
			<td><input type="text" name="name" >	
		<tr>
			<td>電話:
			<td><input type="text" name="phone" >
		<tr>
			<td>學歷:
			<td><input type="radio" name="stud" value="碩士">碩士
				<input type="radio" name="stud" value="大學">大學
				<input type="radio" name="stud" value="高中">高中
				<input type="radio" name="stud" value="國中">國中
		<tr>
			<td colspan=2 align=center >
			<input type="reset" value="清除" >
			<input type="button" value="註冊" onClick="check()">
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