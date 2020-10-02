<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="Dao.billDao"
    import="java.util.List"
    import="Model.bill"%>
<!DOCTYPE html>
<%
	List L = new billDao().query();
%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	
	<h3 align=center>留言板</h3>
	<hr>
	
	<table align=center border=0 width="700">
		<tr>
			<td align=center><a href="../loop/loop" style="text-decoration:none;"><h4>新增留言</h4></a>
			<td ><a href="../member/view" style="text-decoration:none;"><h4>登出</h4>
	</table>
	
	<table align=center border=1 width="700" >	
		<tr align=center >
			<td width="50">編號<td width="100">標題<td width="100">作者<td width="250">內容</td>
			
			<%
				Object o [] = L.toArray();
				String tab ="";
				bill b [] = new bill[100];
				for(int i=0 ; i<o.length;i++){
					 b[i] = (bill)o[i];%>
				
				<%	
					if((b[i].getNote().length()) >= 8) {
						tab = b[i].getNote().subSequence(0, 8)+".....";
					}else{
						tab = b[i].getNote();
					}
	
				out.println("<tr><td align=center>"+b[i].getId()+
						"<td align=center>"+
						"<a href=\"../loop/loopsee?id="+b[i].getId()+"\""+ 
						"style=\"text-decoration:none\";" +
						">"+b[i].getCount()+"</a>"+
						"<td align=center>"+b[i].getName() +"<td>"+tab);	
							
				}
				
			%>
		
			
	</table>
	<hr>


</form>
</body>
</html>