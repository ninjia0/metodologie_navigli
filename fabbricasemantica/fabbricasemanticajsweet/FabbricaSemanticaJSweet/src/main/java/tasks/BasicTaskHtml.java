package tasks;

import static def.dom.Globals.document;
import static def.dom.Globals.location;
import static def.jquery.Globals.$;

import java.util.ArrayList;
import java.util.List;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLButtonElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLParagraphElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;
/**
 * this interface provides all the functions that used in different tasks 
 */

public class BasicTaskHtml {
	
	private static String LOGIN_PAGE="login.html";
	private static final String LOGIN_CHECK = "isLoggedIn.jsp";
	
	public String backGroundColor() {return "rgba(80,38,107,0.46)";}
	
	/**
	 * 
	 * @return a form with post action and bootstrap container
	 */
	public HTMLFormElement formCreator() {
		HTMLFormElement	form = document.createElement(StringTypes.form);
		form.method="POST";
		form.className="container center_div";
		return form;
	}
	/**
	 * 
	 * @return head tag for every html page
	 */
	public HTMLHeadingElement headerCreator() {
		HTMLHeadingElement h1tag = document.createElement(StringTypes.h1);
		h1tag.className="h1 text-center";
		$(h1tag).css("margin-top","15px");
		$(h1tag).css("margin-bottom","100px");
		return h1tag;
	}
	/**
	 * 
	 * @return label element 
	 */
	public HTMLLabelElement labelCreator() {
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.className = "form-control-plaintext";
		$(label).css("font-weight","bold");
		return label;
	} 
	/**
	 * 
	 * @return text area 
	 */
	public HTMLTextAreaElement textAreaCreator() {
		HTMLTextAreaElement ta = document.createElement(StringTypes.textarea);
		ta.name="translation";
		//ta.className =  "form-control";
		ta.placeholder="Write the translation here...";
		return ta;
	}
	
	/**
	 * 
	 * @return a submit button for form submit
	 */
	public HTMLInputElement submitButtonCreator() {
		HTMLInputElement button = document.createElement(StringTypes.input);
		button.className="btn btn-primary btn-rounded";
		button.type="submit";
		return button;
	}
	/**
	 * 
	 * @return div html element 
	 */
	public HTMLDivElement divFormGroupCreator() {
		HTMLDivElement divel=document.createElement(StringTypes.div);
		divel.className="form-group";
		return divel;
	}
	
	/**
	 * 
	 * @return return div element with no class name
	 */
	public HTMLDivElement divCreator() {
		HTMLDivElement divel=document.createElement(StringTypes.div);
		return divel;
	}
	/**
	 * 
	 * @return return a link element
	 */
	public HTMLAnchorElement aCreator() {
		HTMLAnchorElement a = document.createElement(StringTypes.a);
		a.className="dropdown-item";
		return a;
	}
	
	/**
	 * 
	 * @return a button for dropdown menu
	 */
	public HTMLButtonElement buttonCreator() {
		HTMLButtonElement btn = document.createElement(StringTypes.button);
		btn.className="btn btn-secondary";
		btn.setAttribute("data-toggle","dropdown");
		btn.type="button";
		btn.textContent="Menu";
		btn.setAttribute("aria-haspopup", "true");
		btn.setAttribute("aria-expanded", "false");
		$(btn).css("margin","10px");
		return btn;
	}
	/**
	 * 
	 * @return a text paragraph tag
	 */
	public HTMLParagraphElement paragraphCreator() {
		HTMLParagraphElement p = document.createElement(StringTypes.p);
		return p;
	}
	/**
	 * 
	 * @return input with type checkbox
	 */
	public HTMLInputElement checkboxCreator() {
		HTMLInputElement checkbox = document.createElement(StringTypes.input);
		checkbox.setAttribute("data-toggle", "toggle");
		checkbox.type="checkbox";
		checkbox.className="form-check-input";
		checkbox.setAttribute("data-size","xs");
		checkbox.setAttribute("data-on","Yes");
		checkbox.setAttribute("data-off","No");
		checkbox.setAttribute("data-onstyle","primary");
		return checkbox;
	}
	/**
	 * 
	 * @return div element for checkboxes
	 */
	public HTMLDivElement checkboxDivCreator() {
		HTMLDivElement divCheckbox=document.createElement(StringTypes.div);
		divCheckbox.className="checkbox col-5-md";
		$(divCheckbox).css("position","50%");
		$(divCheckbox).css("border", "solid 0.5px blue");
		$(divCheckbox).css("border-radius", "5px");
		$(divCheckbox).css("margin-bottom", "5px");
		return divCheckbox;
	}
	/**
	 * 
	 * @return hidden input tag
	 */
	public HTMLInputElement hiddenInputCreator() {
		HTMLInputElement input = document.createElement(StringTypes.input);
		input.type="hidden";
		input.name="hidden";
		return input;
	}
	
	/**
	 * 
	 * @return div element with all login and logout button
	 */
	public HTMLDivElement menuCreator() {
		HTMLDivElement divMenu = divCreator();
		divMenu.className="dropdown";
		
		HTMLButtonElement menuButton=buttonCreator();
		divMenu.appendChild(menuButton);
		
		HTMLDivElement divList = divCreator();
		divList.className="dropdown-menu";
		
		HTMLAnchorElement home = aCreator();
		home.href="home.html";
		home.textContent="Home Page";
		
		HTMLAnchorElement logout = aCreator();
		logout.href="logout.jsp";
		logout.textContent="Log Out";
		
		$(divList).append(home,logout);
		divMenu.appendChild(divList);
		return divMenu;
	}
	
	/**
	 * if the given textarea is empty that disable the given submit button
	 * @param translation textarea element that has to be checked if it is empty
	 * @param submit button element that has to be disable thile textarea is empty
	 */
	
	public void emptyhandler(HTMLTextAreaElement translation, HTMLInputElement submit) {
		$(document).ready(handler->$(translation).keyup(handler1->{
			if(translation.value.equals("")) {submit.disabled=true;}
			else {submit.disabled=false;}
			return null;
		}));		
	}
	
	/**
	 * check if the user has already logged in
	 */
	public void loginCheck() {
	$.getJSON(LOGIN_CHECK, (Object result, String a, JQueryXHR ctx)->{
		if(result.toString().equals("false")) {
		$(location).attr("href",LOGIN_PAGE);
		}
		return null;
	});
	}
	
	/**
	 * this function takes array of string for label element and create array.length label with div
	 * element finally save all in a list
	 * @param text of String array for label element's context
	 * @return list of div elements
	 */
	
	public List<HTMLDivElement> inputLabelGenerator(String ...text){
		List<HTMLDivElement> inputlabel = new ArrayList<>();
		for(int i=0;i<text.length;i++) {
			HTMLDivElement div =document.createElement(StringTypes.div);
			div.className="custom-control custom-checkbox";
			$(div).css("position","50%");
			$(div).css("border", "solid 0.5px blue");
			$(div).css("border-radius", "5px");
			$(div).css("margin-bottom", "5px");
			
			HTMLLabelElement la =document.createElement(StringTypes.label);
			la.setAttribute("font-weight", "bold");
			la.className="custom-control-label";
			la.setAttribute("for","labelinput-"+i);
			la.textContent=text[i];
			
			HTMLInputElement inp =document.createElement(StringTypes.input);
			inp.type="checkbox";
			inp.value=text[i];
			inp.className="custom-control-input";
			inp.setAttribute("id", "labelinput-"+i);
			inp.name="userchoice";
			$(div).append(inp,la);
			inputlabel.add(div);
		}
		return inputlabel;
	}
	
}
