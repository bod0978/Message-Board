<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.List"
    import="Model.member"
    import="Dao.memberDao"%>
<%
	List l = new memberDao().query();
	Object o[] = l.toArray();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table align=center border=1 width=700>
		<tr  align=center>
			<td>帳號<td>名稱<td>密碼<td>學歷<td>電話<td>權限(1S，0U)<td>編輯
		<%
			member m;
			for(int i=0;i<o.length;i++){
			m = (member)o[i];
			out.println("<tr align=center><td width=100>"+m.getUser()+"<td width=100>"+m.getName()+"<td width=100>"+m.getPassword()+
					"<td width=100>"+m.getStudent()+"<td width=100>"+m.getPhone()+"<td width=100>"+m.getType()+
			"<td align=center><a href=\"../member/Mupdate?id="+m.getId()+ "\" style=\"text-decoration:none\";>編輯</a>");
			}
		%>	
		
	</table>
</body>
</html>