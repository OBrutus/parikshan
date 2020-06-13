<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isErrorPage="true"
   	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hi</title>
</head>
<body>
	Hello, <%= request.getRemoteAddr() %> <br>
	<h2>Are you trying to hack into the system ?</h2><br>
	Lets do it together!<br>
	You contact us, and we will do it together.<br>
	If you are smart enough you will figure out who am I.<br>
	<b>- regards AV7</b>
  <p> Your IP : <%= request.getRemoteAddr()+":"+request.getRemotePort() %> </p>
</body>
</html>
