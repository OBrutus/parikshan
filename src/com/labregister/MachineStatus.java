package com.labregister;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Servlet implementation class MachineStatus
 */
@WebServlet(
		urlPatterns = { "/MachineStatus" }
//		, 
//		initParams = { 
//				@WebInitParam(name = "ip", value = "null", description = "To get the current IP allocated device status")
//		}
)
public final class MachineStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MachineStatus() {
        // TODO Auto-generated constructor stub
//    	FileOutputStream fout=new FileOutputStream("main.log");
//    	fout.write("[MS]: Machine Status checked on " + );
    	System.out.println("Server log");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
