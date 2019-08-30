package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;


@WebServlet(name="CheckExistence", urlPatterns="/checkexistence.jsp")
public class CheckExistence extends BaseServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext path = getServletContext();
		URL file=path.getResource("/WEB-INF/xml/userinfo.xml");
		XmlHandler xml = new XmlHandler(file);
		
		String email=request.getParameter("einput");
		if(xml.checkExistence(email)) {
			System.out.println("inside checkexis:"+email);
			response.getWriter().write("true");}
		else {
			response.getWriter().write("false");}
		
	}
	
	


}
