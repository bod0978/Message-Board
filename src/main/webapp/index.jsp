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
			<td colspan=2 align=center><h3>�n�J����</h3>
		<tr>
			<td>�b��:
			<td><input type="text" name="user" >
		<tr>
			<td>�K�X:
			<td><input type="password" name="password" >
		<tr>
			<td colspan=2 align=center >
			<input type="reset" value="�M��" >
			<input type="button" value="�n�J" onClick="check()">&ensp;&ensp;
			<input type ="button" onclick="javascript:location.href='member/addmv'" value="�|�����U" />
	</table>
</form>

<script type="text/javascript">
	function check()
	{
		if(loginF.user.value=="")
			{
				alert("�b�����i�ť�");
				return ;
			}
		if(loginF.password.value=="")
			{
				alert("�K�X���i�ť�");
				return ;
			}
		loginF.submit();
			
	}
	
</script>



</body>
</html>