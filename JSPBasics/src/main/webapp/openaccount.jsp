<%@ page import="java.sql.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<%! 
    Connection con;
    PreparedStatement ps;
    
    public void jspInit() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
    		ps = con.prepareStatement("INSERT INTO account VALUES (?, ?, ?, ?)");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void jspDestroy(){
    	try{
    	ps.close();
    	con.close();
    	}catch(Exception e){
    		e.printStackTrace();

    	}
    }
    %>

<%
   int accno= Integer.parseInt(request.getParameter("accno"));
   String lastName= request.getParameter("lastname");
   String firstName= request.getParameter("firstname");
   int bal= Integer.parseInt(request.getParameter("bal"));
   
   ps.setInt(1,accno);
   ps.setString(2,lastName);
   ps.setString(3,firstName);
   ps.setInt(4,bal);
   
   ps.executeUpdate();

   
   %>


<%@ include file ="openaccount.html" %>










