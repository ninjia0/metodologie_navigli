package tasks;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLParagraphElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class SenseValidation {
	
	
	public static final String SERVLET_URL = "senseValidation.jsp";
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) {
		BasicTaskHtml sv = new BasicTaskHtml();
		sv.loginCheck();
		
		HTMLFormElement form =sv.formCreator();
		form.action = SERVLET_URL;		
		
		HTMLParagraphElement explanation = sv.paragraphCreator();
		
		HTMLLabelElement phrase = sv.labelCreator();
		HTMLInputElement hiddenInput = sv.hiddenInputCreator();
		
		HTMLInputElement checkbox = sv.checkboxCreator();
		checkbox.setAttribute("data-size","lg");
		checkbox.name="answer";
		
		HTMLParagraphElement sense = sv.paragraphCreator();
		$(sense).css("font-size","20px");
		
		HTMLInputElement submit = sv.submitButtonCreator();
		submit.name = "submit_button";
		submit.value = "Next";

		HTMLInputElement skip = sv.submitButtonCreator();
		skip.name = "skip_button";
		skip.value = "Skip";
		$(skip).css("float", "right");
		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		
		$.getJSON(REST_URL, "task=SENSE_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String word = json.$get("word");
			String ex = json.$get("example");
			String wsense = json.$get("sense");
			$(phrase).text(ex);
			$(explanation).text("Is the word "+ word +"'s sense is correct?");
			sense.textContent=wsense;
			hiddenInput.value="word: "+word+", example: "+ex+", sense: "+wsense;
			return null;
		});
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------

		HTMLDivElement divExplanation = sv.divCreator();
		divExplanation.className="row align-items-center col-3-md";
		$(divExplanation).append(explanation,hiddenInput);
		
		HTMLDivElement divPhrase = sv.divCreator();
		divPhrase.className="row align-items-center col-3-md";
		$(divPhrase).append(phrase);
		
		
		HTMLDivElement divCheckbox = sv.checkboxDivCreator();
		divCheckbox.className="row align-items-center checkbox col-3-md";
		$(divCheckbox).css("border", "None");
		$(divCheckbox).append(checkbox,sense);
		
		HTMLDivElement divAll = sv.divCreator();
		divAll.className="container";
		$(divAll).append(divExplanation, divPhrase);
		$(divAll).append(divCheckbox);
		$(divAll).css("border","ridge 1px");
		
		HTMLDivElement divButtons= sv.divFormGroupCreator();
		$(divButtons).append(submit, skip);
		
		HTMLHeadingElement header= sv.headerCreator();
		header.textContent="Sense Validation";
		
		$(form).append(divAll);
		$(form).append(divButtons);
		
		$("body").css("background-color",sv.backGroundColor());
		$("body").append(sv.menuCreator(),header);
		$("body").append(form);
	}

}
