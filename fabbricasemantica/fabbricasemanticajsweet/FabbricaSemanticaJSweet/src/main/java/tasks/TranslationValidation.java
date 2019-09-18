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

public class TranslationValidation{
	
	
	public static final String SERVLET_URL = "translationValidation.jsp";
	public static final String REST_URL = "nextExample.jsp";
	private static List<HTMLDivElement> inputlabel;
	
	public static void main(String[] args) {
		BasicTaskHtml tv = new BasicTaskHtml();
		tv.loginCheck();
		
		HTMLFormElement form =tv.formCreator();
		form.action = SERVLET_URL;
		
		HTMLParagraphElement explanation = tv.paragraphCreator();
		explanation.className="form-control-plaintext";
		$(explanation).css("float", "left");
		
		HTMLLabelElement description = tv.labelCreator();
		
		HTMLInputElement hidden = tv.hiddenInputCreator();
		
		HTMLInputElement submit = tv.submitButtonCreator();
		submit.name = "submit_button";
		submit.value = "Next";

		HTMLInputElement skip = tv.submitButtonCreator();
		skip.name = "skip_button";
		skip.value = "Skip";
		$(skip).css("float", "right");
		
		HTMLDivElement divButtons= tv.divFormGroupCreator();
		$(divButtons).append(submit, skip);
		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		
		$.getJSON(REST_URL, "task=TRANSLATION_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sword = json.$get("word");
			String sDescription = json.$get("description");
			hidden.value="word: "+sword+", description: "+sDescription;
			$(explanation).text("Choose the correct phrase for the word "+sword);
			$(description).text(sDescription);
			String[] sT = json.$get("translations").toString().split(",");
			
			inputlabel=tv.inputLabelGenerator(sT[0],sT[1],sT[2],"niente di sopra e corretto");
			
			HTMLDivElement divInputLabel = tv.divFormGroupCreator();
			
			for(HTMLDivElement d:inputlabel) {
				$(divInputLabel).append(d);
			}
			$(form).append(divInputLabel);
			$(form).append(divButtons);
			return null;
		});
		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------
		HTMLDivElement divExplanation = tv.divCreator();
		$(divExplanation).append(explanation,hidden);
		
		HTMLDivElement divPhrase = tv.divCreator();
		$(divPhrase).append(description);
		
		//inputlabel.forEach((k,v)->{$(divInputLabel).append(k, v);});
		
		HTMLHeadingElement header = tv.headerCreator();
		header.textContent="Translation Validation";
		
		$(form).append(divExplanation);
		$(form).append(divPhrase);
		
		$("body").css("background-color",tv.backGroundColor());
		$("body").append(tv.menuCreator(),header);
		$("body").append(form);
	}
	
}
