import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PreInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() {
		System.out.println("Pre initialization");
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("Welcome to pre init servlet");
	}

}
