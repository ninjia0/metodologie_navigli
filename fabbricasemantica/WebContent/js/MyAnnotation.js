/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var tasks;
(function (tasks) {
    class MyAnnotation {
        /**
         * this function takes a string for label context and create a list of label elements
         * @param {string} word A string for label element's context
         * @private
         */
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
            let ma = new tasks.BasicTaskHtml();
            ma.loginCheck();
            let form = ma.formCreator();
            form.action = MyAnnotation.SERVLET_URL;
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
            ma.emptyhandler(textarea, submit);
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
                    for (let index258 = 0; index258 < MyAnnotation.labels.length; index258++) {
                        let l = MyAnnotation.labels[index258];
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
    }
    MyAnnotation.SERVLET_URL = "myAnnotation.jsp";
    MyAnnotation.REST_URL = "nextExample.jsp";
    MyAnnotation.labels = null;
    tasks.MyAnnotation = MyAnnotation;
    MyAnnotation["__class"] = "tasks.MyAnnotation";
})(tasks || (tasks = {}));
tasks.MyAnnotation.main(null);
