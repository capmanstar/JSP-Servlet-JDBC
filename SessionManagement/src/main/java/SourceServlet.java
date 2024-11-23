import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
			}
		}
		String username = req.getParameter("userName");
		HttpSession session = req.getSession();
		session.setAttribute("user", username);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String url = "targetServlet?sessionID=123";
		out.print("<a href='" + url + "'>Click here to get user name</a>");
		//resp.addCookie(new Cookie("securityToken","12345"));
		session.setMaxInactiveInterval(60);
	}

}
