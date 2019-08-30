/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Login {
        constructor() {
        }
        headerCreator() {
            let h1tag = document.createElement("h1");
            $(h1tag).css("text-align", "center");
            h1tag.textContent = "Fabbrica Semantica";
            return h1tag;
        }
        checkBoxCreator() {
            let langinput = document.createElement("input");
            langinput.type = "checkbox";
            langinput.className = "custom-control-input";
            return langinput;
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
        LabelCreator() {
            let label = document.createElement("label");
            label.className = "custom-control-label";
            return label;
        }
        buttonCreator() {
            let button = document.createElement("button");
            return button;
        }
        static main(args) {
            let log = new Login();
            let h1tag = log.headerCreator();
            h1tag.className = "text-center my-3 mb-5";
            $("body").append(h1tag);
            let form = log.formCreator();
            form.action = Login.SERVLET_URL;
            let einput = log.inputCreator();
            einput.className = "form-control";
            einput.type = "email";
            einput.placeholder = "Enter Email";
            einput.name = "user-email";
            einput.required = true;
            let pinput = log.inputCreator();
            pinput.className = "form-control";
            pinput.type = "password";
            pinput.placeholder = "Enter Password";
            pinput.name = "user-password";
            let sbutton = log.inputCreator();
            sbutton.className = "btn btn-primary";
            sbutton.type = "Submit";
            $(sbutton).css("width", "100%");
            let styleclass = log.divCreator();
            styleclass.className = "col-xs-12 col-lg-4 container";
            let divEmail = log.divCreator();
            divEmail.className = "form-group";
            $(divEmail).append(einput);
            let link = document.createElement("a");
            link.href = "signup.html";
            link.text = "no account? register";
            $(link).css("color", "white");
            let divpass = log.divCreator();
            divpass.className = "form-group";
            $(divpass).append(pinput);
            $(divpass).append(link);
            let row = log.divCreator();
            row.className = "row mb-5 mt-5 col-1";
            let row1 = log.divCreator();
            row1.className = "row mb-5 col-1";
            $("body").css("background-color", Login.BACKGROUNDCOLOR);
            $("body").append(row, row1);
            $(form).append(divEmail);
            $(form).append(divpass);
            $(form).append(sbutton);
            $(styleclass).append(form);
            $("body").append(styleclass);
        }
    }
    Login.BACKGROUNDCOLOR = "rgba(80,38,107,0.46)";
    Login.SERVLET_URL = "login.jsp";
    quickstart.Login = Login;
    Login["__class"] = "quickstart.Login";
    Login["__interfaces"] = ["quickstart.BasicHtml"];
})(quickstart || (quickstart = {}));
quickstart.Login.main(null);
