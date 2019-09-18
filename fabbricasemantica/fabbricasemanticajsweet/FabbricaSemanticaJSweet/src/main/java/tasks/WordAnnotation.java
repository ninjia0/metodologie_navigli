package tasks;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLParagraphElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

public class WordAnnotation{
	
	public static final String SERVLET_URL = "wordAnnotation.jsp";
	public static final String REST_URL = "nextExample.jsp";
	
	
	public static void main(String[] args) {
		BasicTaskHtml wa = new BasicTaskHtml();
		wa.loginCheck();
		
		HTMLFormElement form =wa.formCreator();
		form.action = SERVLET_URL;
		
		HTMLParagraphElement description = wa.paragraphCreator();
		HTMLInputElement hiddenInput = wa.hiddenInputCreator();
		
		
		description.className="form-control-plaintext";
		$(description).css("float", "left");
		$(description).css("word-wrap", "break-word");
				
		HTMLTextAreaElement translation = wa.textAreaCreator();
		translation.className="md-textarea form-control";
		translation.placeholder="Given a definition of a word try to guess the word...";
		translation.id="form24";
		translation.rows=3;

		HTMLInputElement submit = wa.submitButtonCreator();
		submit.name = "submit_button";
		submit.value = "Next";
		submit.disabled=true;
		
		HTMLInputElement skip = wa.submitButtonCreator();
		skip.name = "skip_button";
		skip.value = "Skip";
		$(skip).css("float", "right"); //il pulsante skip sara' messo piu' a destra possibile
		
		wa.emptyhandler(translation,submit);
		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		//Object result e' il nostro oggetto JSON
		$.getJSON(REST_URL, "task=WORD_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sDescription = json.$get("description"); //i.e. json.get("description")
			$(description).text(sDescription);
			hiddenInput.value="sDescription";
			return null;
		});
		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------

		HTMLDivElement divDescription = wa.divCreator();
		divDescription.className="col-3 col-form-label mr-2";
		$(divDescription).append(description,hiddenInput);
		
		HTMLDivElement divTranslation = wa.divFormGroupCreator();
		divTranslation.className="col-8 md-form amber-textarea active-amber-textarea-2";
		$(divTranslation).append(translation);
		
		HTMLDivElement dido = wa.divCreator();
		dido.className="form-group row";
		$(dido).append(divDescription,divTranslation);

		HTMLDivElement divButtons= wa.divFormGroupCreator();
		$(divButtons).append(submit, skip);
		
		HTMLDivElement divMenu = wa.menuCreator();
		
		
		$(form).append(dido);
		$(form).append(divButtons);
		
		HTMLHeadingElement header= wa.headerCreator();
		header.textContent="Word Annotation";
		
		
		$("body").css("background-color",wa.backGroundColor());
		$("body").append(divMenu,header);
		$("body").append(form);
	}
	
}
