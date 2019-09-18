package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import jsweet.util.StringTypes;

public class Login implements BasicHtml {
	private static String BACKGROUNDCOLOR="rgba(80,38,107,0.46)";
	public static final String SERVLET_URL = "login.jsp";
	
	public static void main(String[] args) {
		Login log = new Login();
		
		//h1 tag
		HTMLHeadingElement h1tag = log.headerCreator();
		h1tag.className="text-center my-3 mb-5";
		$("body").append(h1tag);
		
		
		//create form
		HTMLFormElement form=log.formCreator();
		form.action=SERVLET_URL;
		
		//create email input
		HTMLInputElement einput = log.inputCreator();
		einput.className="form-control";
		einput.type="email";
		einput.placeholder="Enter Email";
		einput.name="user-email";
		einput.required=true;
		
		//create password input 
		HTMLInputElement pinput = log.inputCreator();
		pinput.className="form-control";
		pinput.type="password";
		pinput.placeholder="Enter Password";
		pinput.name="user-password";
		
		//create submit button
		HTMLInputElement sbutton = log.inputCreator();
		sbutton.className="btn btn-primary";
		sbutton.type="Submit";
		$(sbutton).css("width","100%");
		
		
		
		//----------make divelement for bootstrap------------------
		
		HTMLDivElement styleclass = log.divCreator();
		styleclass.className="col-xs-12 col-lg-4 container";
		
		HTMLDivElement divEmail = log.divCreator();
		divEmail.className="form-group";
		$(divEmail).append(einput);
		
		HTMLAnchorElement link = document.createElement(StringTypes.a);
		link.href="signup.html";
		link.text="no account? register";
		$(link).css("color","white");
		//$(link).css("text-decoration","none");
		
		
		HTMLDivElement divpass = log.divCreator();
		divpass.className="form-group";
		$(divpass).append(pinput);
		$(divpass).append(link);
		
		HTMLDivElement row = log.divCreator();
		row.className="row mb-5 mt-5 col-1";
		
		HTMLDivElement row1 = log.divCreator();
		row1.className="row mb-5 col-1";
		
		$("body").css("background-color",BACKGROUNDCOLOR);
		$("body").append(row,row1);
		$(form).append(divEmail);
		$(form).append(divpass);
		$(form).append(sbutton);
		$(styleclass).append(form);
		$("body").append(styleclass);
		
	}


}
