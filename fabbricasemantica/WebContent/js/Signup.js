/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Signup {
        constructor() {
        }
        buttonCreator() {
            let button = document.createElement("button");
            return button;
        }
        headerCreator() {
            let h1tag = document.createElement("h1");
            $(h1tag).css("text-align", "center");
            h1tag.textContent = "Fabbrica Semantica";
            return h1tag;
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
        divCreator() {
            let divel = document.createElement("div");
            return divel;
        }
        LabelCreator() {
            let label = document.createElement("label");
            label.className = "custom-control-label";
            return label;
        }
        inputCreator() {
            let eel = document.createElement("input");
            $(eel).css("color", "white");
            $(eel).css("border-radius", "5px");
            $(eel).css("background-color", "rgba(8,8,8,0.87)");
            return eel;
        }
        checkBoxCreator() {
            let langinput = document.createElement("input");
            langinput.type = "checkbox";
            langinput.className = "custom-control-input";
            return langinput;
        }
        static main(args) {
            let sup = new Signup();
            let h1tag = sup.headerCreator();
            h1tag.className = "text-center my-3";
            $("body").append(h1tag);
            let form = sup.formCreator();
            form.action = Signup.SERVLET_URL;
            let einput = sup.inputCreator();
            einput.className = "form-control";
            einput.type = "email";
            einput.placeholder = "Enter Email";
            einput.name = "user-email";
            einput.required = true;
            let pinput = sup.inputCreator();
            pinput.className = "form-control";
            pinput.type = "password";
            pinput.placeholder = "Enter The Password";
            pinput.name = "user-password";
            pinput.id = "password1";
            let rpinput = sup.inputCreator();
            rpinput.className = "form-control";
            rpinput.type = "password";
            rpinput.id = "password2";
            rpinput.placeholder = "Repeat The Password";
            let sbutton = sup.inputCreator();
            sbutton.className = "btn btn-primary";
            sbutton.type = "Submit";
            $(sbutton).css("width", "100%");
            let nativediv = sup.divCreator();
            nativediv.className = "form-group";
            let langlabel = sup.LabelCreator();
            langlabel.textContent = "choose your native language:";
            langlabel.className = "lable";
            $(nativediv).append(langlabel);
            let divcheckbox = sup.divCreator();
            divcheckbox.className = "custom-control custom-checkbox col-sm-5";
            let langen = sup.LabelCreator();
            langen.textContent = "English";
            langen.setAttribute("for", "checkboxen");
            let checkboxen = sup.checkBoxCreator();
            checkboxen.name = "native-language-en";
            checkboxen.value = "native-language-enlgish";
            checkboxen.id = "checkboxen";
            $(divcheckbox).append(checkboxen);
            $(divcheckbox).append(langen);
            let divcheckbox2 = sup.divCreator();
            divcheckbox2.className = "custom-control custom-checkbox col-sm-5";
            let langit = sup.LabelCreator();
            langit.textContent = "Italian";
            langit.setAttribute("for", "checkboxit");
            let checkboxit = sup.checkBoxCreator();
            checkboxit.name = "native-language-it";
            checkboxit.value = "native-language-italian";
            checkboxit.id = "checkboxit";
            $(divcheckbox2).append(checkboxit);
            $(divcheckbox2).append(langit);
            $(nativediv).append(divcheckbox);
            $(nativediv).append(divcheckbox2);
            let divlang = sup.divCreator();
            divlang.className = "form-group";
            let otherlanguagelabel = sup.LabelCreator();
            otherlanguagelabel.textContent = "choose other languages that you can speak:";
            otherlanguagelabel.className = "lable";
            $(divlang).append(otherlanguagelabel);
            let englishleveldiv = sup.divCreator();
            englishleveldiv.className = "custom-control custom-checkbox col-sm-5";
            let otherlangen = sup.LabelCreator();
            otherlangen.textContent = "English level:";
            otherlangen.setAttribute("for", "othercheckboxen");
            let othercheckboxen = sup.checkBoxCreator();
            othercheckboxen.name = "other-language-en";
            othercheckboxen.value = "other-language-enlgish";
            othercheckboxen.id = "othercheckboxen";
            $(englishleveldiv).append(othercheckboxen, otherlangen);
            let el1 = sup.inputCreator();
            el1.type = "number";
            el1.setAttribute("min", "1");
            el1.setAttribute("max", "10");
            el1.name = "en-level";
            el1.className = "form-control";
            el1.placeholder = "1 to 10";
            $(englishleveldiv).append(el1);
            $(divlang).append(englishleveldiv);
            let divsection = sup.divCreator();
            divsection.className = "custom-control custom-checkbox col-sm-5";
            let othercheckboxit = sup.checkBoxCreator();
            othercheckboxit.name = "other-language-it";
            othercheckboxit.value = "other-language-italian";
            othercheckboxit.setAttribute("id", "checkboxit1");
            let lab = sup.LabelCreator();
            lab.textContent = "Italian Level:";
            lab.setAttribute("for", "checkboxit1");
            $(divsection).append(othercheckboxit);
            $(divsection).append(lab);
            let el = sup.inputCreator();
            el.type = "number";
            el.setAttribute("min", "1");
            el.setAttribute("max", "10");
            el.name = "it-level";
            el.className = "form-control";
            el.placeholder = "1 to 10";
            $(divsection).append(el);
            $(divlang).append(divsection);
            $(document).ready(((sbutton) => {
                return (war) => $(sbutton).click((event) => {
                    if (!(checkboxen.checked || checkboxit.checked)) {
                        alert("please choose your native language!!!");
                        return false;
                    }
                    else if (!(othercheckboxen.checked || othercheckboxit.checked)) {
                        alert("please choose your second langue!!!");
                        return false;
                    }
                    else if ($(pinput).val() !== $(rpinput).val()) {
                        alert("The two passwords do not match!!!");
                        return false;
                    }
                    else {
                        return true;
                    }
                });
            })(sbutton));
            let warning = sup.LabelCreator();
            warning.className = "label";
            $(warning).css("color", "#e22525");
            $(warning).css("font-weight", "bold");
            $(document).ready(((einput) => {
                return (handler) => {
                    $(einput).blur((event) => {
                        let or = einput.value;
                        if (or !== "" && (or.indexOf("@") != -1) && !((or.indexOf("\\") != -1))) {
                            $.getJSON(Signup.CHECK_EXISTENCE, "einput=" + or, (result, a, ctx) => {
                                let e = result.toString();
                                console.info(e);
                                if (((o1, o2) => { if (o1 && o1.equals) {
                                    return o1.equals(o2);
                                }
                                else {
                                    return o1 === o2;
                                } })(e, "true") || e == null) {
                                    warning.textContent = "*This email already registered";
                                    form.action = "";
                                }
                                else if (((o1, o2) => { if (o1 && o1.equals) {
                                    return o1.equals(o2);
                                }
                                else {
                                    return o1 === o2;
                                } })(e, "false")) {
                                    warning.textContent = "";
                                    form.action = Signup.SERVLET_URL;
                                }
                                return null;
                            });
                        }
                        else {
                            warning.textContent = "";
                            return true;
                        }
                        return null;
                    });
                    return null;
                };
            })(einput));
            let styleclass = sup.divCreator();
            styleclass.className = "col-xs-12 col-lg-4 container mt-3";
            let divEmail = sup.divCreator();
            divEmail.className = "form-group";
            $(divEmail).append(einput, warning);
            let divpass = sup.divCreator();
            divpass.className = "form-group";
            $(divpass).append(pinput);
            let divrpass = sup.divCreator();
            divrpass.className = "form-group";
            $(divrpass).append(rpinput);
            let link = document.createElement("a");
            link.href = "login.html";
            link.text = "have an account? please login";
            link.className = "btn btn-link";
            $(link).css("color", "white");
            $("body").css("background-color", "rgba(80,38,107,0.46)");
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
    Signup.SERVLET_URL = "singup.jsp";
    Signup.CHECK_EXISTENCE = "checkexistence.jsp";
    quickstart.Signup = Signup;
    Signup["__class"] = "quickstart.Signup";
    Signup["__interfaces"] = ["quickstart.BasicHtml"];
})(quickstart || (quickstart = {}));
quickstart.Signup.main(null);
