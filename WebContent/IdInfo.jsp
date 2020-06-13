<%@page import="com.database.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    errorPage="/Error404.jsp"
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ID Info</title>
</head>
<body>
<%
	UserInfo info=(UserInfo)request.getAttribute("info");
	if(info==null)
		out.println("Null ");
%>
  <h1>This is Info about <%= request.getAttribute("prn") %></h1>
  <img src="<%= request.getAttribute("imageLocation") %>" alt="" id="image"> <br>
  name : <%= info.getName() %> <br>
  PRN :  <%= info.getprn() %> <br>
  year : <%= info.getYear() %> <br> <%= request.getAttribute("year") %>
  Branch : <%= info.getBranch() %> <br>
  Permenant Address : <%= info.getPermAddr() %> <br>
  Hostel Block : <%= info.getHostelBlock() %><br>
  Fees Paid: <%= info.getFeesPaid() %><br>
  Admission Date: <%= info.getAdmdate() %>
  
  <script type="text/javascript">
    // img=document.getElementById('image');
    // img.alt=<%= request.getAttribute("prn") %>;
    // img.src=<%= request.getAttribute("imageLocation") %>;
  </script>
</body>
</html>
