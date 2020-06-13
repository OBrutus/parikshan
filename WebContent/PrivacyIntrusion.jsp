<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Know your Limits</title>
</head>
<body>
  Hey, <%= request.getRemoteUser() %>
  Know your limits, don't try to alter anyone's Privacy.
  <p hidden="hidden"><%= exception.getMessage() %></p>
</body>
</html>
