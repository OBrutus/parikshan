package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseInteraction {

	public DatabaseInteraction() {}

	// JDBC driver name and database URL
	   private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	   private final  String DB_URL = "jdbc:mysql://localhost/project";

	   //  Database credentials
	   private final String USER = "root";
	   private final String PASS = "";
	   
	   //Connection object
	   private Connection conn = null;
	   
	   public boolean connectDB()
	   {
	      try{
	         //STEP 2: Register JDBC driver
	         Class.forName(JDBC_DRIVER);
	   
	         //STEP 3: Open a connection
	         System.out.println("Connecting to database...");
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);
	         if(conn!=null)
	         {
	            System.out.println("Connected..!");
	            return true;
	         }
	      }catch(SQLException se){
	         //Handle errors for JDBC
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException SE){
	            SE.printStackTrace();
	         }
	         se.printStackTrace();
	         return false;
	      }catch(Exception e){
	         //Handle errors for Class.forName
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException SE){
	            SE.printStackTrace();
	         }
	         e.printStackTrace();
	         return false;
	      }
	      System.out.println("Welcome!");
	      return true;
	   }

	   public boolean disconnectDB()
	   {
	      try{
	         if(conn!=null)
	         {
	            System.out.println("Disconnected..!");
	            conn.close();
	         }
	         return true;
	      }catch(SQLException SE){
	         SE.printStackTrace();
	         return false;
	      }
	   }

	   public boolean registerUser(String prn, String pass)
	   {
	      Statement stmt = null;
	      try{
	         stmt = conn.createStatement();
	         String sql;
	         sql = "INSERT INTO Users values(" + "'"+prn +"'"+ "," + "MD5("+"'"+ pass+"'"+")" + ")";
	         int rowsInserted = stmt.executeUpdate(sql);
	         if (rowsInserted > 0) {
	            return true;
	         }
	      }
	      catch(SQLException se){
	         //Handle errors for JDBC
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException SE){
	            SE.printStackTrace();
	         }
	         se.printStackTrace();
	         return false;
	      }catch(Exception e){
	         //Handle errors for Class.forName
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException SE){
	            SE.printStackTrace();
	         }
	         e.printStackTrace();
	         return false;
	      }
	      return true;
	   }

	   public boolean validate(String username, String pass)
	   {
	      Statement stmt = null;
	      try{
	         stmt = conn.createStatement();
	         String sql,sql1;
	         sql = "SELECT UserPassword FROM Users where UserId=" + "'" + username + "'";
	         sql1 = "SELECT " + "MD5('" + pass + "')" + "AS PASS";   
	         ResultSet rs = stmt.executeQuery(sql1);
	         String userPass="",givenPass="";
	         while(rs.next())
	            givenPass  = rs.getString("PASS");
	         rs = stmt.executeQuery(sql);
	         while(rs.next())
	            userPass  = rs.getString("UserPassword");
	         rs.close();
	         if(userPass.equals(givenPass))
	            return true;
	         else
	            return false;
	      }
	      catch(SQLException se){
	         //Handle errors for JDBC
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException SE){
	            SE.printStackTrace();
	         }
	         se.printStackTrace();
	         return false;
	      }catch(Exception e){
	         //Handle errors for Class.forName
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException SE){
	            SE.printStackTrace();
	         }
	         e.printStackTrace();
	         return false;
	      }
	   }

	   public boolean setInfo(UserInfo u)
	   {
	      String prn;
	      String rc_no;
	      Date admission_date;
	      String name;
	      String year;
	      String branch;
	      String local_address;
	      String perm_address;
	      boolean feesPaid;
	      prn=u.getprn();
	      rc_no=u.getrcn();
	      admission_date=u.getAdmdate();
	      name=u.getName();
	      year=u.getYear();
	      branch=u.getBranch();
	      local_address=u.getLocAddr();
	      perm_address=u.getPermAddr();
	      feesPaid=u.getFeesPaid();
	      Statement stmt = null;
	      try{
	         stmt = conn.createStatement();
	         String sql;
	         sql = "INSERT INTO Student_Info values(" + "'"+prn+"'"+ "," + "'"+rc_no+"'"+ ","+ "'"+admission_date+"'"+ ","+ "'"+name+"'"+ ","+ "'"+year+"'"+ ","+ "'"+branch+"'"+ ","+ "'"+local_address+"'"+ ","+ "'"+perm_address+"'"+ ","+feesPaid+ ")";
	         int rowsInserted = stmt.executeUpdate(sql);
	         if (rowsInserted > 0) {
	            return true;
	         }
	      }
	      catch(SQLException se){
	         //Handle errors for JDBC
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException SE){
	            SE.printStackTrace();
	         }
	         se.printStackTrace();
	         return false;
	      }catch(Exception e){
	         //Handle errors for Class.forName
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException SE){
	            SE.printStackTrace();
	         }
	         e.printStackTrace();
	         return false;
	      }
	      return true;
	   }
	   
	   public UserInfo getInfo(String ID)
	   {
	      Statement stmt = null;
	      try{
	         stmt = conn.createStatement();
	         String sql;
	         sql = "SELECT * FROM Student_Info where prn=" + "'" + ID + "'";
	         ResultSet rs = stmt.executeQuery(sql);
	         String prn="";
	         String rc_no="";
	         Date admission_date=new Date(2000-01-01);
	         String name="";
	         String year="";
	         String branch="";
	         String local_address="";
	         String permanent_address="";
	         boolean feesPaid=false;
	         while(rs.next())
	         {
	            prn = rs.getString("prn");
	            rc_no = rs.getString("rc_no");
	            admission_date = rs.getDate("admission_date");
	            name = rs.getString("name");
	            year = rs.getString("year");
	            branch = rs.getString("branch");
	            local_address = rs.getString("local_address");
	            permanent_address = rs.getString("permanent_address");
	            feesPaid = rs.getBoolean("fees_paid");
	         }
	         UserInfo u = new UserInfo(prn,
	          rc_no,
	          admission_date,
	          name,
	          year,
	          branch,
	          local_address,
	          permanent_address,
	          feesPaid);
	         rs.close();
	         return u;
	      }
	      catch(SQLException se){
	         //Handle errors for JDBC
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException SE){
	            SE.printStackTrace();
	         }
	         se.printStackTrace();
	         return null;
	      }catch(Exception e){
	         //Handle errors for Class.forName
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException SE){
	            SE.printStackTrace();
	         }
	         e.printStackTrace();
	         return null;
	      }
	   }
}
