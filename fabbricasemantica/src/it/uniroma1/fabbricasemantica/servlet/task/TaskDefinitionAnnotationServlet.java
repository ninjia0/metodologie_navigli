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

@WebServlet(name = "TaskDefinitionAnnotationServlet", urlPatterns = "/definitionAnnotation.jsp")
public class TaskDefinitionAnnotationServlet extends BaseServlet {
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
		String translation = request.getParameter("translation");
		String word = request.getParameter("hidden");
		Object name = request.getSession().getAttribute("useremail");
		
		if(skip!=null) {
			response.sendRedirect(page.getRandomPage("definitionAnnotation.html"));
		}
		if(submit!=null) {
			try {
				var.WriteXMl(name.toString(), StandardTask.DEFINITION_ANNOTATION, word, Arrays.asList(translation));
			} catch (Exception e) {
				response.sendRedirect("errorPage.html");return;
			}
			response.sendRedirect(page.getRandomPage("definitionAnnotation.html"));
		}
	}

}
