<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="style.css">  
  </head>
  <body> 
  	<%
		Integer attempts=(Integer)session.getAttribute("failedAttempts");
		if(attempts == null){
			attempts=0;
		}else{
			out.println("Invalid cred.Failed attempts : "+ attempts);
      		//if( ! request.getParameter("password").toString().equals("noincrement"))
		    	attempts++;
		}
		request.getSession().setAttribute("failedAttempts", attempts);
  	%>
  	<div class="login">
	<h1>Login</h1>
    	<form class="form" action="ValidateLogin" method="post">
    	<hr>
    	  <input type="text" name="username" value="" placeholder="Username" required><br>
	      <input type="password" name="password" value="" placeholder="Password" required><br>
        	<button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>      	<hr>
    	</form>
    </div>
    <!--
    <div class="login">
	<h1>Login</h1>
    <form method="post">
    	<input type="text" name="username" placeholder="Username" required="required" />
        <input type="password" name="password" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form>
	</div>
	-->
  </body>
</html>
