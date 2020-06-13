package com.labregister;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DatabaseInteraction;

@WebServlet(description = "To validate the login Makes use of LoginDao", urlPatterns = { "/ValidateLogin" })
public class ValidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ValidateLogin() {
        super();
//        System.setOut();
//        System.setErr();
    }

    public static String md5(String message){
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
           
            //converting byte array to Hexadecimal String
           StringBuilder sb = new StringBuilder(2*hash.length);
           for(byte b : hash){
               sb.append(String.format("%02x", b&0xff));
           }
          
           digest = sb.toString();
          
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return digest;
    }
    
    
    private boolean isValid(String username, String password) {
    	DatabaseInteraction dbi=new DatabaseInteraction();
    	dbi.connectDB();
       	return dbi.validate(username, password);
    }
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.append("Served at: ").append(request.getContextPath());
		out.print('\n');
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		out.println(username+" : "+password);
		System.out.println("Request from "+request.getRemoteUser()+"@"+request.getRemoteAddr());
		if(username==null || password==null )
			response.sendRedirect("PCLogin.jsp");
		if( !isValid(username, password) ) {
			out.println(username);
			System.err.println("[-] Failed Login from user: "+request.getRemoteUser()+" ip:"+request.getRemoteAddr());
			response.sendRedirect("PCLogin.jsp");
		}else {
			request.getSession().setAttribute("isLogin", true);
			request.getSession().setAttribute("failedAttempts", 0);
			System.out.println("login success "+username);
			request.getRequestDispatcher("ReleaseLabLogin.jsp").forward(request, response);
			// release Lock
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
