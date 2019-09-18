package myannotation;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import java.util.LinkedList;
import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;
import tasks.BasicTaskHtml;

class MyAnnotation{
	
	public static final String SERVLET_URL = "myAnnotation.jsp";
	private static String LOGIN_PAGE="login.html";
	public static final String LOGIN_CHECK = "isLoggedIn.jsp";
	public static final String REST_URL = "nextExample.jsp";
	public static List<HTMLLabelElement> labels;
	
	private static void labelGenerator(String word) {
		labels = new LinkedList<>();
		for(int i=0;i<word.length();i++) {
			HTMLLabelElement l =document.createElement(StringTypes.label);
			l.textContent=word.charAt(i)+"";
			$(l).css("margin","5px");
			$(l).css("font-weight","bold");
			$(l).css("font-size", "large");
			$(l).css("border-bottom", "solid 1px blue");
			$(l).css("border-position","absolute");
			labels.add(l);
		}
	}
	
	public static void main(String[] args) {
		
		$.getJSON(LOGIN_CHECK, (Object result, String a, JQueryXHR ctx)->{
			if(result.toString().equals("false")) {
			document.location.href=LOGIN_PAGE;
			}
			return null;
		});
		
		BasicTaskHtml ma = new BasicTaskHtml();
		
		HTMLFormElement form =ma.formCreator();
		form.action = SERVLET_URL;
		form.method = "POST";
		
		HTMLTextAreaElement textarea = ma.textAreaCreator();
		textarea.className="md-textarea form-control";
		textarea.rows=1;
		textarea.placeholder="Make a correct word from the text above (use all letters)...";
		HTMLInputElement hidden = ma.hiddenInputCreator();
		
		HTMLInputElement submit = ma.submitButtonCreator();
		submit.name = "submit_button";
		submit.value = "Next";
		submit.disabled=true;

		HTMLInputElement skip = ma.submitButtonCreator();
		skip.name = "skip_button";
		skip.value = "Skip";
		$(skip).css("float", "right"); 
		
		HTMLDivElement divButtons= ma.divFormGroupCreator();
		$(divButtons).append(submit, skip);
		
		emptyhandler(textarea,submit);
		
		HTMLDivElement divTextarea = ma.checkboxDivCreator();
		divTextarea.className="col-12 md-form amber-textarea active-amber-textarea-2";
		$(divTextarea).css("border", "None");
		$(divTextarea).append(textarea,hidden);
		
		// ---------------PRENDIAMO L'ESEMPIO DAL SERVER ------------------- 
		
		$.getJSON(REST_URL, "task=MY_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String word = json.$get("word");
			
			hidden.value=word;
			labelGenerator(word);
			HTMLDivElement divWords = ma.divCreator();
			for(HTMLLabelElement l:labels) {
				$(divWords).append(l);
			}
			divWords.setAttribute("style", "text-align:center");
			divWords.title="make a correct word from me";
			$(form).append(divWords);
			$(form).append(divTextarea);
			$(form).append(divButtons);
			
			return null;
		});
		
		
		HTMLHeadingElement header = ma.headerCreator();
		header.textContent="My Annotation";
		
		$("body").css("background-color",ma.backGroundColor());
		$("body").append(ma.menuCreator(),header);
		$("body").append(form);
	}
	
	private static void emptyhandler(HTMLTextAreaElement translation, HTMLInputElement submit) {
		$(document).ready(handler->$(translation).keyup(handler1->{
			if(translation.value.equals("")) {submit.disabled=true;}
			else {submit.disabled=false;}
			return null;
		}));		
	}

}
