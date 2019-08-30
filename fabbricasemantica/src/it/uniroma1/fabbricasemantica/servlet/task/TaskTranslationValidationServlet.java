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

@WebServlet(name = "TaskTranslationValidationServlet", urlPatterns = "/translationValidation.jsp")
public class TaskTranslationValidationServlet extends BaseServlet {
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
		String word = request.getParameter("hidden");
		String[] checkboxes = request.getParameterValues("userchoice");
		Object name = request.getSession().getAttribute("useremail");
		if(skip!=null) {
			response.sendRedirect(page.getRandomPage("translationValidation.html"));
		}
		if(submit!=null) {
			try {
				var.WriteXMl(name.toString(), StandardTask.TRANSLATION_VALIDATION, word, Arrays.asList(checkboxes));
			} catch (Exception  e) {
				response.sendRedirect("errorPage.html");return; //use return in order to skip line 46;
			}
			response.sendRedirect(page.getRandomPage("translationValidation.html"));
		}
		
	}

}
