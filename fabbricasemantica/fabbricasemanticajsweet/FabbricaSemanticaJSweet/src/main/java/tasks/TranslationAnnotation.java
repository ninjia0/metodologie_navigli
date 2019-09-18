package tasks;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;


public class TranslationAnnotation {
	
	public static final String SERVLET_URL = "translationAnnotation.jsp";
	public static final String REST_URL = "nextExample.jsp";
	public static void main(String[] args) {
		
		BasicTaskHtml ta = new BasicTaskHtml();
		ta.loginCheck();
		
		HTMLFormElement form =ta.formCreator();
		form.action = SERVLET_URL;
		
		HTMLLabelElement description = ta.labelCreator();
				
		HTMLLabelElement word = ta.labelCreator();
		HTMLInputElement hiddenInput = ta.hiddenInputCreator();

		HTMLInputElement submit = ta.submitButtonCreator();
		submit.name = "submit_button";
		submit.id="submitbutton";
		submit.value = "Next";
		submit.disabled=true;
		
		HTMLTextAreaElement translation = ta.textAreaCreator();
		translation.className="form-control z-depth-1";
		
		ta.emptyhandler(translation,submit);

		HTMLInputElement skip = ta.submitButtonCreator();
		skip.name = "skip_button";
		skip.value = "Skip";
		$(skip).css("float", "right");
		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		
		$.getJSON(REST_URL, "task=TRANSLATION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			String sDescription = json.$get("description"); //i.e. json.get("description")
			$(word).text(sWord);
			hiddenInput.value=sWord;
			$(description).text(sDescription);
			return null;
		});
		
		
		HTMLDivElement divWord = ta.divCreator();
		$(divWord).append(word,hiddenInput);

		HTMLDivElement divDescription = ta.divFormGroupCreator();
		$(divDescription).append(description);
		
		HTMLDivElement divTranslation = ta.divFormGroupCreator();
		divTranslation.className="form-group shadow-textarea";
		$(divTranslation).append(translation);
		
		HTMLDivElement divButtons= ta.divFormGroupCreator();
		$(divButtons).append(submit, skip);
		
		HTMLDivElement divMenu = ta.menuCreator(); 
		
		$(form).append(divWord);
		$(form).append(divDescription);
		$(form).append(divTranslation);
		$(form).append(divButtons);
		
		$("body").css("background-color",ta.backGroundColor());
		
		HTMLHeadingElement header= ta.headerCreator();
		header.textContent="Translation Annotation";
		
		$("body").append(divMenu,header);
		$("body").append(form);
	}

}
