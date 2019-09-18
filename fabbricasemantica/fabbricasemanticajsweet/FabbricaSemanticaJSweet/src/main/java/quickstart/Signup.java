package quickstart;

import static def.dom.Globals.alert;
import static def.dom.Globals.document;
import static def.jquery.Globals.$;


import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

public class Signup implements BasicHtml{
	
	public static final String SERVLET_URL = "singup.jsp";
	public static final String CHECK_EXISTENCE="checkexistence.jsp";
	
	public static void main(String[] args) {
		Signup sup = new Signup();
		
		//h1 tag
		HTMLHeadingElement h1tag = sup.headerCreator();
		h1tag.className="text-center my-3";
		$("body").append(h1tag);
		
		//create form
		HTMLFormElement form = sup.formCreator();
		form.action=SERVLET_URL;
		
		//create email input
		HTMLInputElement einput = sup.inputCreator();
		einput.className="form-control";
		einput.type="email";
		einput.placeholder="Enter Email";
		einput.name="user-email";
		einput.required=true;
		
		//create password input 
		HTMLInputElement pinput = sup.inputCreator();
		pinput.className="form-control";
		pinput.type="password";
		pinput.placeholder="Enter The Password";
		pinput.name="user-password";
		pinput.id="password1";
		//repeat
		
		HTMLInputElement rpinput = sup.inputCreator();
		rpinput.className="form-control";
		rpinput.type="password";
		rpinput.id="password2";
		rpinput.placeholder="Repeat The Password";
		
		
		//create submit button
		HTMLInputElement sbutton = sup.inputCreator();
		sbutton.className="btn btn-primary";
		sbutton.type="Submit";
		$(sbutton).css("width","100%");

		
		//----------make divelement for bootstrap------------------
		HTMLDivElement nativediv = sup.divCreator();
		nativediv.className="form-group";
		
		HTMLLabelElement langlabel = sup.LabelCreator();
		langlabel.textContent="choose your native language:";
		langlabel.className="lable";
		$(nativediv).append(langlabel);
		
		
		HTMLDivElement divcheckbox = sup.divCreator();
		divcheckbox.className="custom-control custom-checkbox col-sm-5";
		
		HTMLLabelElement langen = sup.LabelCreator();
		langen.textContent="English";
		langen.setAttribute("for", "checkboxen");
		
		HTMLInputElement checkboxen = sup.checkBoxCreator();
		checkboxen.name="native-language-en";
		checkboxen.value="native-language-enlgish";
		checkboxen.id="checkboxen";
		
		$(divcheckbox).append(checkboxen);
		$(divcheckbox).append(langen);
		
		HTMLDivElement divcheckbox2 = sup.divCreator();
		divcheckbox2.className="custom-control custom-checkbox col-sm-5";
		
		HTMLLabelElement langit = sup.LabelCreator();
		langit.textContent="Italian";
		langit.setAttribute("for", "checkboxit");
		
		HTMLInputElement checkboxit = sup.checkBoxCreator();
		checkboxit.name="native-language-it";
		checkboxit.value="native-language-italian";
		checkboxit.id="checkboxit";
		
		$(divcheckbox2).append(checkboxit);
		$(divcheckbox2).append(langit);
		
		$(nativediv).append(divcheckbox);
		$(nativediv).append(divcheckbox2);
		
		HTMLDivElement divlang = sup.divCreator();
		divlang.className="form-group";
		
		HTMLLabelElement otherlanguagelabel = sup.LabelCreator();
		otherlanguagelabel.textContent="choose other languages that you can speak:";
		otherlanguagelabel.className="lable";
		$(divlang).append(otherlanguagelabel);
		
		HTMLDivElement englishleveldiv = sup.divCreator();
		englishleveldiv.className="custom-control custom-checkbox col-sm-5";
		
		HTMLLabelElement otherlangen = sup.LabelCreator();
		otherlangen.textContent="English level:";
		otherlangen.setAttribute("for", "othercheckboxen");
		
		HTMLInputElement othercheckboxen = sup.checkBoxCreator();
		othercheckboxen.name="other-language-en";
		othercheckboxen.value="other-language-enlgish";
		othercheckboxen.id="othercheckboxen";
		
		$(englishleveldiv).append(othercheckboxen,otherlangen);
		
		HTMLInputElement el1 = sup.inputCreator();
		el1.type="number";
		el1.setAttribute("min", "1");
		el1.setAttribute("max", "10");
		el1.name="en-level";
		el1.className="form-control";
		el1.placeholder="1 to 10";
		$(englishleveldiv).append(el1);
		$(divlang).append(englishleveldiv);

		HTMLDivElement divsection = sup.divCreator();
		divsection.className="custom-control custom-checkbox col-sm-5";
		
		HTMLInputElement othercheckboxit = sup.checkBoxCreator();
		othercheckboxit.name="other-language-it";
		othercheckboxit.value="other-language-italian";
		othercheckboxit.setAttribute("id", "checkboxit1");
		
		HTMLLabelElement lab=sup.LabelCreator();
		lab.textContent="Italian Level:";
		lab.setAttribute("for", "checkboxit1");
		
		$(divsection).append(othercheckboxit);
		$(divsection).append(lab);
		
		HTMLInputElement el = sup.inputCreator();
		el.type="number";
		el.setAttribute("min", "1");
		el.setAttribute("max", "10");
		el.name="it-level";
		el.className="form-control";
		el.placeholder="1 to 10";
		$(divsection).append(el);
		$(divlang).append(divsection);
		
		//check is the user checked the language area
		$(document).ready(war->$(sbutton).click(event->{
			if(!(checkboxen.checked || checkboxit.checked)) {
				alert("please choose your native language!!!");
				return false;
			}
			else if(!(othercheckboxen.checked || othercheckboxit.checked)) {
				alert("please choose your second langue!!!");
				return false;
			}
			else if($(pinput).val()!=$(rpinput).val()) {
				alert("The two passwords do not match!!!");
				return false;
			}
			else {return true;}
			}));
		
		HTMLLabelElement warning=sup.LabelCreator();
		warning.className="label";
		$(warning).css("color", "#e22525");
		$(warning).css("font-weight","bold");
		
		$(document).ready(handler->{
			$(einput).blur(event->{
				String or=einput.value;
				if(or!=""&&or.contains("@")&&!(or.contains("\\"))) {
					$.getJSON(CHECK_EXISTENCE,"einput="+or,(Object result, String a, JQueryXHR ctx)->{
					String e = result.toString();
					System.out.println(e);
					if(e.equals("true") || e==null) {warning.textContent="*This email already registered";form.action="";}
					else if(e.equals("false")){warning.textContent="";form.action=SERVLET_URL;}
					return null;
				});
				}
				else {warning.textContent="";return true;}
				return null;
			});
			return null;
		});
		
		
		HTMLDivElement styleclass = sup.divCreator();
		//styleclass.className="col-md-offset-3 col-md-6";
		styleclass.className="col-xs-12 col-lg-4 container mt-3";
		
		HTMLDivElement divEmail = sup.divCreator();
		divEmail.className="form-group";
		$(divEmail).append(einput,warning);

		
		HTMLDivElement divpass = sup.divCreator();
		divpass.className="form-group";
		$(divpass).append(pinput);
		
		HTMLDivElement divrpass = sup.divCreator();
		divrpass.className="form-group";
		$(divrpass).append(rpinput);
		
		HTMLAnchorElement link = document.createElement(StringTypes.a);
		link.href="login.html";
		link.text="have an account? please login";
		link.className="btn btn-link";
		$(link).css("color","white");
		
		
		//create form
		$("body").css("background-color","rgba(80,38,107,0.46)");
		$(form).append(divEmail);
		$(form).append(divpass);
		$(form).append(divrpass);
		$(form).append(nativediv);
		$(form).append(divlang);
		$(form).append(link);
		$(form).append(sbutton);
		$(styleclass).append(form);
		$("body").append(styleclass);
		
	}




}
