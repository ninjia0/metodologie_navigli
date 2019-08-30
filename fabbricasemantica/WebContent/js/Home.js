/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Home {
        constructor() {
        }
        LabelCreator() {
            let label = document.createElement("label");
            label.className = "custom-control-label";
            return label;
        }
        divCreator() {
            let divel = document.createElement("div");
            return divel;
        }
        inputCreator() {
            let eel = document.createElement("input");
            $(eel).css("color", "white");
            $(eel).css("border-radius", "5px");
            $(eel).css("background-color", "rgba(8,8,8,0.87)");
            return eel;
        }
        formCreator() {
            let form = document.createElement("form");
            form.method = "post";
            $(form).css("background-color", "rgba(63,34,136,0.09)");
            $(form).css("color", "white");
            $(form).css("padding", "40px");
            $(form).css("box-shadox", "10px 10px rgba(6,1,1,0.43)");
            $(form).css("border-radius", "15px 50px 30px");
            return form;
        }
        headerCreator() {
            let h1tag = document.createElement("h1");
            $(h1tag).css("text-align", "center");
            h1tag.textContent = "Fabbrica Semantica";
            return h1tag;
        }
        buttonCreator() {
            let button = document.createElement("button");
            return button;
        }
        checkBoxCreator() {
            let langinput = document.createElement("input");
            langinput.type = "checkbox";
            langinput.className = "custom-control-input";
            return langinput;
        }
        static main(args) {
            $.getJSON(Home.LOGIN_CHECK, (result, a, ctx) => {
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(result.toString(), "false")) {
                    document.location.href = Home.LOGIN_PAGE;
                }
                return null;
            });
            let webname = new quickstart.RandomPageChooser();
            let home = new Home();
            let logout = document.createElement("button");
            logout.className = "btn btn-danger btn-rounded";
            logout.textContent = "Log Out";
            logout.hidden = true;
            let play = document.createElement("button");
            play.className = "btn btn-primary btn-rounded";
            play.textContent = "Play ... ";
            play.hidden = true;
            let div = home.divCreator();
            $(div).append(home.headerCreator());
            let img = document.createElement("img");
            img.src = "start.gif";
            img.className = "";
            $(img).css("cursor", "pointer");
            let imdiv = home.divCreator();
            imdiv.className = "btn-group d-flex justify-content-around";
            $(imdiv).css("top", "50%");
            $(imdiv).css("transform", "translateY(-50%)");
            $(imdiv).css("position", "absolute");
            $(imdiv).css("width", "100%");
            $(imdiv).append(logout);
            $(imdiv).append(img);
            $(imdiv).append(play);
            $(document).ready(((img) => {
                return (war) => $(img).click((event) => {
                    logout.hidden = false;
                    play.hidden = false;
                    return null;
                });
            })(img));
            $(document).ready(((play) => {
                return (war) => $(play).click((event) => {
                    $(location).attr("href", webname.getRandomPage());
                    return null;
                });
            })(play));
            $(document).ready(((logout) => {
                return (war) => $(logout).click((event) => {
                    $.getJSON(Home.LOGOUT);
                    $(location).attr("href", Home.LOGIN_PAGE);
                    return null;
                });
            })(logout));
            $("body").append(div);
            $("body").append(imdiv);
        }
    }
    Home.LOGIN_CHECK = "isLoggedIn.jsp";
    Home.LOGIN_PAGE = "login.html";
    Home.LOGOUT = "logout.jsp";
    quickstart.Home = Home;
    Home["__class"] = "quickstart.Home";
    Home["__interfaces"] = ["quickstart.BasicHtml"];
})(quickstart || (quickstart = {}));
quickstart.Home.main(null);
