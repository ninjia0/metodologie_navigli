package tasks;

import static def.jquery.Globals.$;

import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLParagraphElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class SenseAnnotation {
	
	public static final String SERVLET_URL = "senseAnnotation.jsp";
	public static final String REST_URL = "nextExample.jsp";
	private static List<HTMLDivElement> inputlabel;
	
	public static void main(String[] args) {
		BasicTaskHtml sa = new BasicTaskHtml();
		sa.loginCheck();
		
		HTMLFormElement form =sa.formCreator();
		form.action = SERVLET_URL;
		
		
		HTMLParagraphElement explanation = sa.paragraphCreator();
		HTMLInputElement hidden = sa.hiddenInputCreator();
		
		HTMLLabelElement phrase = sa.labelCreator();
		explanation.className="form-control-plaintext";

		HTMLInputElement submit = sa.submitButtonCreator();
		submit.name = "submit_button";
		submit.value = "Next";

		HTMLInputElement skip = sa.submitButtonCreator();
		skip.name = "skip_button";
		skip.value = "Skip";
		$(skip).css("float", "right");
		HTMLDivElement divButtons= sa.divFormGroupCreator();
		$(divButtons).append(submit, skip);
		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		
		$.getJSON(REST_URL, "task=SENSE_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sword = json.$get("word");
			String sDescription = json.$get("description");
			hidden.value="word: "+sword+", description: "+sDescription;
			$(explanation).text("Choose the correct meaning of the word \""+sword+"\"");
			$(phrase).text(sDescription);
			String[] sT = json.$get("senses").toString().split(",");
			
			inputlabel=sa.inputLabelGenerator(sT[0],sT[1],sT[2],sT[3]);
			
			HTMLDivElement divInputLabel = sa.divFormGroupCreator();
		
			for(HTMLDivElement d:inputlabel) {
				$(divInputLabel).append(d);
			}
			$(form).append(divInputLabel);
			$(form).append(divButtons);
			return null;
		});
		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------

		HTMLDivElement divExplanation = sa.divCreator();
		$(divExplanation).append(explanation,hidden);
		
		HTMLDivElement divPhrase = sa.divCreator();
		$(divPhrase).append(phrase);
		
		
		HTMLHeadingElement header = sa.headerCreator();
		header.textContent="Sense Annotation";
		
		$(form).append(divExplanation);
		$(form).append(divPhrase);
		$(form).append(divButtons);
		
		$("body").css("background-color",sa.backGroundColor());
		$("body").append(sa.menuCreator(),header);
		$("body").append(form);
	}

}
