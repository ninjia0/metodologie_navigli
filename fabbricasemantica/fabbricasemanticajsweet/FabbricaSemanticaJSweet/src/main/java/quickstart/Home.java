package quickstart;

import static def.dom.Globals.document;
import static def.dom.Globals.location;
import static def.jquery.Globals.$;

import def.dom.HTMLButtonElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLImageElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

public class Home implements BasicHtml{
	
	
	private static String LOGIN_CHECK="isLoggedIn.jsp";
	private static String LOGIN_PAGE="login.html";
	private static String LOGOUT="logout.jsp";
	
	public static void main(String[] args) {
		$.getJSON(LOGIN_CHECK, (Object result, String a, JQueryXHR ctx)->{
			if(result.toString().equals("false")) {
			document.location.href=LOGIN_PAGE;
			}
			return null;
		});
		
		RandomPageChooser webname = new RandomPageChooser();
		Home home = new Home();

		
		HTMLButtonElement logout = document.createElement(StringTypes.button);
		logout.className="btn btn-danger btn-rounded";
		logout.textContent="Log Out";
		logout.hidden=true;
		
		HTMLButtonElement play = document.createElement(StringTypes.button);
		play.className="btn btn-primary btn-rounded";
		play.textContent="Play ... ";
		play.hidden=true;
		
		HTMLDivElement div = home.divCreator();
		$(div).append(home.headerCreator());
		
		HTMLImageElement img = document.createElement(StringTypes.img);
		img.src="start.gif";
		img.className="";
		$(img).css("cursor","pointer");
		
		HTMLDivElement imdiv = home.divCreator();
		imdiv.className="btn-group d-flex justify-content-around";
		$(imdiv).css("top","50%");
		$(imdiv).css("transform","translateY(-50%)");
		$(imdiv).css("position","absolute");
		$(imdiv).css("width","100%");
		
		$(imdiv).append(logout);
		$(imdiv).append(img);
		$(imdiv).append(play);
		
		$(document).ready(war->$(img).click(event->{
			logout.hidden=false;
			play.hidden=false;
			return null;
			}));
		
		$(document).ready(war->$(play).click(event->{
			$(location).attr("href", webname.getRandomPage());
			return null;
		}));
		
		$(document).ready(war->$(logout).click(event->{
			$.getJSON(LOGOUT);
			$(location).attr("href", LOGIN_PAGE);
			return null;
		}));
		
		$("body").append(div);
		$("body").append(imdiv);
		
		}

}
