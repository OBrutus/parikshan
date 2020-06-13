package com.id;

import com.database.DatabaseInteraction;
import com.database.UserInfo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	basic
	hostel	 
	library
	all
*/


@WebServlet(description = "gives out the ID's as per the request", urlPatterns = { "/ID"})
public class ID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ID() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String prn=request.getParameter("prn").toUpperCase();
		if( prn==null || prn=="" )
			response.sendRedirect("Error404.jsp");
		String idType=request.getParameter("id_type");
		DatabaseInteraction dbi=new DatabaseInteraction();
		dbi.connectDB();
		UserInfo info=dbi.getInfo(prn);
//		response.getWriter().append("\n Got request for "+idType+ " from "+ prn);
//		request.setAttribute("image", "/images/"+prn);
		request.setAttribute("info", info);
		request.setAttribute("year", info.getYear().toUpperCase().trim());
		request.setAttribute("name", info.getName());
		request.setAttribute("prn", prn.toUpperCase());
		System.out.println("ID type "+idType+ " prn:"+prn+" name:"+info.getName());
		request.setAttribute("imageLocation", "images/"+prn.toLowerCase()+".jpg");
		System.out.println("img: "+request.getAttribute("imageLocation"));
//		File file=new File("images/"+prn+"jpg");
//		System.out.println(file);
//		BufferedImage image = ImageIO.read(file);
//		ImageIO.write(image, "JPG", response.getOutputStream());
		switch(idType) {
			case "basic":
				//basic id card
				break;
			case "hostel": 
				//hostel id card
				request.setAttribute("rcn", info.getrcn());
//				request.setAttribute("block", info.getblock());
				break;
			case "library":
				//lib
				break;
			case "all":
				//all
				request.setAttribute("rcNumber", info.getrcn());
				break;
			default:
				request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
		request.getRequestDispatcher("IdInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
