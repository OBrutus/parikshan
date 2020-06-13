<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	errorPage="HackIn.jsp"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Release Lab Login</title>
</head>
<body>
	<p>Welcome <b id='username'>
		<%
			Boolean isLogin=(Boolean)session.getAttribute("isLogin");
			if( isLogin==null || !isLogin || request.getParameter("username")==null ){
				throw new Exception();
			}
			out.println(request.getParameter("username"));
		%>
	</b> Good to see you! </p>
	<script>
		const {ipcRenderer}=require('electron');
		ipcRenderer.send('exit');
		let token=getElmentById('username').text;
		console.log(token);
	</script>
</body>
</html>
