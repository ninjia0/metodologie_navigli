package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;


@WebServlet(name="LoginServlet", urlPatterns="/login.jsp")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;
	private static HttpSession session;
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("user-email");
		String pass  = request.getParameter("user-password");
		ServletContext path = getServletContext();
		URL file=path.getResource("/WEB-INF/xml/userinfo.xml");
		XmlHandler xml  =  new XmlHandler(file);
		if (xml.userEmailCheck(email, pass)) {
			session=request.getSession();
			session.setAttribute("useremail", email);
			response.sendRedirect("home.html");
		}
		else {
			response.sendRedirect("login.html");
		}
	}
	
}
