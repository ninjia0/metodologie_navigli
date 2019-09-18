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

public class DefinitionAnnotation {

	public static final String SERVLET_URL = "definitionAnnotation.jsp";
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) {
		BasicTaskHtml da = new BasicTaskHtml();
		da.loginCheck();
		
		HTMLFormElement form =da.formCreator();
		form.action = SERVLET_URL;
		
		HTMLParagraphElement word = da.paragraphCreator();
		HTMLInputElement hiddenInput = da.hiddenInputCreator();
		
		word.className="form-control-plaintext";
		$(word).css("float", "left");
		$(word).css("word-wrap", "break-word");
				
		HTMLTextAreaElement translation = da.textAreaCreator();
		translation.className="md-textarea form-control";
		translation.placeholder="Given a word and hyperonym write the definition in your language... ";
		translation.id="form24";
		translation.rows=3;

		HTMLInputElement submit = da.submitButtonCreator();
		submit.name = "submit_button";
		submit.value = "Next";
		submit.disabled=true;
		
		HTMLInputElement skip = da.submitButtonCreator();
		skip.name = "skip_button";
		skip.value = "Skip";
		$(skip).css("float", "right"); 
		
		da.emptyhandler(translation,submit);
		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		
		$.getJSON(REST_URL, "task=DEFINITION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String oword = json.$get("word");
			String ohypernym= json.$get("hypernym");
			$(word).text(oword+"---"+ohypernym);
			hiddenInput.value="word: "+oword+", hypername: "+ohypernym;
			return null;
		});
		
		//---------------FORMATTIAMO LA PAGINA CON BOOTSTRAP -------------------

		HTMLDivElement divDescription = da.divCreator();
		divDescription.className="col-3 col-form-label mr-2";
		$(divDescription).append(word,hiddenInput);
		
		HTMLDivElement divTranslation = da.divFormGroupCreator();
		divTranslation.className="col-8 md-form amber-textarea active-amber-textarea-2";
		$(divTranslation).append(translation);
		
		HTMLDivElement dido = da.divCreator();
		dido.className="form-group row";
		$(dido).append(divDescription,divTranslation);

		HTMLDivElement divButtons= da.divFormGroupCreator();
		$(divButtons).append(submit, skip);
		
		HTMLHeadingElement header= da.headerCreator();
		header.textContent="Definition Annotation";
		
		$(form).append(dido);
		$(form).append(divButtons);
		$("body").css("background-color",da.backGroundColor());
		$("body").append(da.menuCreator(),header);
		$("body").append(form);
	}

	
}
