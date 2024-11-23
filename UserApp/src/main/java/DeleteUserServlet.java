import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteServlet")
public class DeleteUserServlet extends HttpServlet {
	private Connection connection;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
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
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("delete from user where email='"+email+"'");
			PrintWriter writer = response.getWriter();
			if(result>0)
				writer.println("<h3>USER DELETED</h3>");
			else
				writer.println("<h3>USER NOT FOUND</h3>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
