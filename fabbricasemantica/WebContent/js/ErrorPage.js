/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var myannotation;
(function (myannotation) {
    class ErrorPage {
        static main(args) {
            $.getJSON(ErrorPage.LOGIN_CHECK, (result, a, ctx) => {
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(result.toString(), "false")) {
                    document.location.href = ErrorPage.LOGIN_PAGE;
                }
                return null;
            });
            let error = document.createElement("h1");
            error.className = "col-12";
            error.setAttribute("style", "font-size:500%");
            let message = document.createElement("h1");
            message.className = "h1 col-12";
            message.textContent = "Oops! There Is Something Wrong With This Page.";
            let link = document.createElement("a");
            link.className = "col-12";
            link.setAttribute("style", "font-size:30px");
            link.textContent = "Click here to go back to home page";
            link.href = ErrorPage.HOME_PAGE;
            let div = document.createElement("div");
            div.setAttribute("style", "font-family:times ; text-align:center");
            $(div).append(error);
            $(div).append(message, link);
            $.getJSON(ErrorPage.SERVLET_URL, ((error) => {
                return (result, a, ctx) => {
                    let json = result;
                    let er = (json["error"]);
                    error.textContent = er + " Error :(";
                    return null;
                };
            })(error));
            $("body").css("display", "grid");
            $("body").css("height", "100vh");
            $("body").css("place-items", "center center");
            $("body").append(div);
        }
    }
    ErrorPage.SERVLET_URL = "errorPage.jsp";
    ErrorPage.LOGIN_PAGE = "login.html";
    ErrorPage.HOME_PAGE = "home.html";
    ErrorPage.LOGIN_CHECK = "isLoggedIn.jsp";
    myannotation.ErrorPage = ErrorPage;
    ErrorPage["__class"] = "myannotation.ErrorPage";
})(myannotation || (myannotation = {}));
myannotation.ErrorPage.main(null);
