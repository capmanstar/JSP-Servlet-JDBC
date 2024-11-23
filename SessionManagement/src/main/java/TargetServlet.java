

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/targetServlet")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
		}
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("User name is: "+username);
	}


}
