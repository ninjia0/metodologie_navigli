/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var myannotation;
(function (myannotation) {
    class MyAnnotation {
        /*private*/ static labelGenerator(word) {
            MyAnnotation.labels = ([]);
            for (let i = 0; i < word.length; i++) {
                {
                    let l = document.createElement("label");
                    l.textContent = word.charAt(i) + "";
                    $(l).css("margin", "5px");
                    $(l).css("font-weight", "bold");
                    $(l).css("font-size", "large");
                    $(l).css("border-bottom", "solid 1px blue");
                    $(l).css("border-position", "absolute");
                    /* add */ (MyAnnotation.labels.push(l) > 0);
                }
                ;
            }
        }
        static main(args) {
            $.getJSON(MyAnnotation.LOGIN_CHECK, (result, a, ctx) => {
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(result.toString(), "false")) {
                    document.location.href = MyAnnotation.LOGIN_PAGE;
                }
                return null;
            });
            let ma = new tasks.BasicTaskHtml();
            let form = ma.formCreator();
            form.action = MyAnnotation.SERVLET_URL;
            form.method = "POST";
            let textarea = ma.textAreaCreator();
            textarea.className = "md-textarea form-control";
            textarea.rows = 1;
            textarea.placeholder = "Make a correct word from the text above (use all letters)...";
            let hidden = ma.hiddenInputCreator();
            let submit = ma.submitButtonCreator();
            submit.name = "submit_button";
            submit.value = "Next";
            submit.disabled = true;
            let skip = ma.submitButtonCreator();
            skip.name = "skip_button";
            skip.value = "Skip";
            $(skip).css("float", "right");
            let divButtons = ma.divFormGroupCreator();
            $(divButtons).append(submit, skip);
            MyAnnotation.emptyhandler(textarea, submit);
            let divTextarea = ma.checkboxDivCreator();
            divTextarea.className = "col-12 md-form amber-textarea active-amber-textarea-2";
            $(divTextarea).css("border", "None");
            $(divTextarea).append(textarea, hidden);
            $.getJSON(MyAnnotation.REST_URL, "task=MY_ANNOTATION", ((hidden, ma, form, divTextarea, divButtons) => {
                return (result, a, ctx) => {
                    let json = result;
                    let word = (json["word"]);
                    hidden.value = word;
                    MyAnnotation.labelGenerator(word);
                    let divWords = ma.divCreator();
                    for (let index121 = 0; index121 < MyAnnotation.labels.length; index121++) {
                        let l = MyAnnotation.labels[index121];
                        {
                            $(divWords).append(l);
                        }
                    }
                    divWords.setAttribute("style", "text-align:center");
                    divWords.title = "make a correct word from me";
                    $(form).append(divWords);
                    $(form).append(divTextarea);
                    $(form).append(divButtons);
                    return null;
                };
            })(hidden, ma, form, divTextarea, divButtons));
            let header = ma.headerCreator();
            header.textContent = "My Annotation";
            $("body").css("background-color", ma.backGroundColor());
            $("body").append(ma.menuCreator(), header);
            $("body").append(form);
        }
        /*private*/ static emptyhandler(translation, submit) {
            $(document).ready((handler) => $(translation).keyup((handler1) => {
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(translation.value, "")) {
                    submit.disabled = true;
                }
                else {
                    submit.disabled = false;
                }
                return null;
            }));
        }
    }
    MyAnnotation.SERVLET_URL = "myAnnotation.jsp";
    MyAnnotation.LOGIN_PAGE = "login.html";
    MyAnnotation.LOGIN_CHECK = "isLoggedIn.jsp";
    MyAnnotation.REST_URL = "nextExample.jsp";
    MyAnnotation.labels = null;
    myannotation.MyAnnotation = MyAnnotation;
    MyAnnotation["__class"] = "myannotation.MyAnnotation";
})(myannotation || (myannotation = {}));
myannotation.MyAnnotation.main(null);
