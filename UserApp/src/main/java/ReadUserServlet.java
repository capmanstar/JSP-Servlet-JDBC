import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadUserServlet extends HttpServlet {
	private Connection connection;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(config.getInitParameter("dbURL"), config.getInitParameter("dbUser"), config.getInitParameter("dbPassword"));
		}
		catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public void destroy() {
		try {
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user");
			PrintWriter out = response.getWriter();
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>");
			out.println("First Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Last Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Email");
			out.print("</th>");
			out.print("</tr>");
			out.print("</table>");
			while(resultSet.next()) {
				out.print("<tr>");
				out.print("<td>");
				out.println(resultSet.getString(1));
				out.print("</td>");
				out.print("<td>");
				out.println(resultSet.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.println(resultSet.getString(3));
				out.print("</td>");
				out.print("</tr>");
				out.println("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
