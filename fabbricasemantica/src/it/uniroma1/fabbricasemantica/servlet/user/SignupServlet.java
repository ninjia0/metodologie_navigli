package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name="SignupServlet", urlPatterns="/singup.jsp")
public class SignupServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;

	@Override

	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext path = getServletContext();
		URL file=path.getResource("/WEB-INF/xml/userinfo.xml");
		//String file1 = path.getRealPath("/WEB-INF/xml/userinfo.xml");
		String email = request.getParameter("user-email");
		String repass= request.getParameter("user-password");
		String langen  = request.getParameter("native-language-en");
		String langit = request.getParameter("native-language-it");
		String otherlangen = request.getParameter("other-language-en");
		String otherlangit = request.getParameter("other-language-it");
		String enlevel = request.getParameter("en-level");
		String itlevel = request.getParameter("it-level");
		
		XmlHandler xml = new XmlHandler(file);
		System.out.println(file.getPath());
		xml.writeToXml(email, repass, new String[]{lc(langen),lc(langit)}, lc(otherlangen)+"-"+lc(enlevel),lc(otherlangit)+"-"+lc(itlevel));
		response.sendRedirect("login.html");
		
	}
	
	private String lc(String input) {
		String output="";
		if(input!=null) {
			String[] a=input.split("-");
			output=a[a.length-1];
		}
		return output;
	}

}
