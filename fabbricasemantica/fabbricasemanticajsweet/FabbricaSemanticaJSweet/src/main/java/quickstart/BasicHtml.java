package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import def.dom.HTMLButtonElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import jsweet.util.StringTypes;

public interface BasicHtml {
	
	default HTMLFormElement formCreator() {
		
		HTMLFormElement	form = document.createElement(StringTypes.form);
		form.method="post";
		$(form).css("background-color","rgba(63,34,136,0.09)");
		$(form).css("color","white");
		$(form).css("padding","40px");
		$(form).css("box-shadox","10px 10px rgba(6,1,1,0.43)");
		$(form).css("border-radius","15px 50px 30px");
		return form;
	}
	default HTMLDivElement divCreator() {
		HTMLDivElement divel=document.createElement(StringTypes.div);
		return divel;
	}
	default HTMLInputElement inputCreator() {
		HTMLInputElement eel= document.createElement(StringTypes.input);
		$(eel).css("color","white");
		$(eel).css("border-radius","5px");
		$(eel).css("background-color","rgba(8,8,8,0.87)");
		return eel;
	}
	
	/**
	 * 
	 * @return Array of HTML input element first enlgish then italian
	 */
	default HTMLInputElement checkBoxCreator() {
		HTMLInputElement langinput = document.createElement(StringTypes.input);
		langinput.type="checkbox";
		langinput.className="custom-control-input";
		return langinput;
	}
	
	default HTMLLabelElement LabelCreator() {
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.className="custom-control-label";
		return label;
	} 
	default HTMLButtonElement buttonCreator() {
		HTMLButtonElement button = document.createElement(StringTypes.button);
		return button;
	}
	default HTMLHeadingElement headerCreator() {
		//if give this function an argument choose text
		//java compile it well but javascript gives me an error
		HTMLHeadingElement h1tag = document.createElement(StringTypes.h1);
		$(h1tag).css("text-align","center");
		//$(h1tag).css("color","white");
		h1tag.textContent="Fabbrica Semantica";
		return h1tag;
	}

}
