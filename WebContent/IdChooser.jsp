<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    errorPage="PrivacyIntrusion.jsp"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ID Chooser</title> 
</head>
<body>
  Select the ID Type <br>
  <form class="" action="ID" method="get">
    Make this hidden : <input type="text" name="prn" value=""> <br>
    <input type="radio" name="id_type" value="basic"> College ID <br>
    <input type="radio" name="id_type" value="hostel"> Hostel ID <br>
    <input type="radio" name="id_type" value="library"> Library ID <br>
    <input type="radio" name="id_type" value="all"> All ID <br>
    <input type="submit" name="" value="Get ID">
  </form>

</body>
</html>
