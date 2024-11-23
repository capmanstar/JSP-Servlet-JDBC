

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/addServlet", initParams = {@WebInitParam(name="dbURL",value="jdbc:mysql://localhost/mydb"), 
		@WebInitParam(name="dbUser",value="root"), @WebInitParam(name="dbPassword",value="root")})
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into user values('"+firstName+"','"+lastName+"','"+email+"','"+password+"')");
			PrintWriter writer = response.getWriter();
			if(result>0)
				writer.println("<h1>USER CREATED</h1>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void init(ServletConfig config) {
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

}
