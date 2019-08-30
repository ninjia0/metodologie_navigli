/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var tasks;
(function (tasks) {
    class WordAnnotation {
        static main(args) {
            let wa = new tasks.BasicTaskHtml();
            wa.loginCheck();
            let form = wa.formCreator();
            form.action = WordAnnotation.SERVLET_URL;
            let description = wa.paragraphCreator();
            let hiddenInput = wa.hiddenInputCreator();
            description.className = "form-control-plaintext";
            $(description).css("float", "left");
            $(description).css("word-wrap", "break-word");
            let translation = wa.textAreaCreator();
            translation.className = "md-textarea form-control";
            translation.placeholder = "Given a definition of a word try to guess the word...";
            translation.id = "form24";
            translation.rows = 3;
            let submit = wa.submitButtonCreator();
            submit.name = "submit_button";
            submit.value = "Next";
            submit.disabled = true;
            let skip = wa.submitButtonCreator();
            skip.name = "skip_button";
            skip.value = "Skip";
            $(skip).css("float", "right");
            wa.emptyhandler(translation, submit);
            $.getJSON(WordAnnotation.REST_URL, "task=WORD_ANNOTATION", ((description, hiddenInput) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sDescription = (json["description"]);
                    $(description).text(sDescription);
                    hiddenInput.value = "sDescription";
                    return null;
                };
            })(description, hiddenInput));
            let divDescription = wa.divCreator();
            divDescription.className = "col-3 col-form-label mr-2";
            $(divDescription).append(description, hiddenInput);
            let divTranslation = wa.divFormGroupCreator();
            divTranslation.className = "col-8 md-form amber-textarea active-amber-textarea-2";
            $(divTranslation).append(translation);
            let dido = wa.divCreator();
            dido.className = "form-group row";
            $(dido).append(divDescription, divTranslation);
            let divButtons = wa.divFormGroupCreator();
            $(divButtons).append(submit, skip);
            let divMenu = wa.menuCreator();
            $(form).append(dido);
            $(form).append(divButtons);
            let header = wa.headerCreator();
            header.textContent = "Word Annotation";
            $("body").css("background-color", wa.backGroundColor());
            $("body").append(divMenu, header);
            $("body").append(form);
        }
    }
    WordAnnotation.SERVLET_URL = "wordAnnotation.jsp";
    WordAnnotation.REST_URL = "nextExample.jsp";
    tasks.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "tasks.WordAnnotation";
})(tasks || (tasks = {}));
tasks.WordAnnotation.main(null);
