package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.uniroma1.fabbricasemantica.data.StandardTask;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "TaskMyAnnotationServlet", urlPatterns = "/myAnnotation.jsp")
public class TaskMyAnnotationServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * save all user information to the file
	 * if error occurres an error send user to  error page
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext path = getServletContext();
		
		String pa = path.getRealPath(FilePath.getVARPath());
		RandomPage page = new RandomPage();
		
		ValidationAnnotationRegister var = new ValidationAnnotationRegister(pa);
		
		String submit=request.getParameter("submit_button");
		String skip=request.getParameter("skip_button");
		String answer = request.getParameter("translation");
		String word = request.getParameter("hidden");
		Object name = request.getSession().getAttribute("useremail");
		
		if(skip!=null) {
			response.sendRedirect(page.getRandomPage("myAnnotation"));
		}
		if(submit!=null) {
			try {
				var.WriteXMl(name.toString(), StandardTask.MY_ANNOTATION, word, Arrays.asList(answer));
			} catch (Exception e) {
				response.sendRedirect("errorPage.html");return;
			}
			response.sendRedirect(page.getRandomPage("myAnnotation"));
		}
	}

}
