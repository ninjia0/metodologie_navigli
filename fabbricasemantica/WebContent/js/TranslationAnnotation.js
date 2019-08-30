/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var tasks;
(function (tasks) {
    class TranslationAnnotation {
        static main(args) {
            let ta = new tasks.BasicTaskHtml();
            ta.loginCheck();
            let form = ta.formCreator();
            form.action = TranslationAnnotation.SERVLET_URL;
            let description = ta.labelCreator();
            let word = ta.labelCreator();
            let hiddenInput = ta.hiddenInputCreator();
            let submit = ta.submitButtonCreator();
            submit.name = "submit_button";
            submit.id = "submitbutton";
            submit.value = "Next";
            submit.disabled = true;
            let translation = ta.textAreaCreator();
            translation.className = "form-control z-depth-1";
            ta.emptyhandler(translation, submit);
            let skip = ta.submitButtonCreator();
            skip.name = "skip_button";
            skip.value = "Skip";
            $(skip).css("float", "right");
            $.getJSON(TranslationAnnotation.REST_URL, "task=TRANSLATION_ANNOTATION", ((description, hiddenInput, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    $(word).text(sWord);
                    hiddenInput.value = sWord;
                    $(description).text(sDescription);
                    return null;
                };
            })(description, hiddenInput, word));
            let divWord = ta.divCreator();
            $(divWord).append(word, hiddenInput);
            let divDescription = ta.divFormGroupCreator();
            $(divDescription).append(description);
            let divTranslation = ta.divFormGroupCreator();
            divTranslation.className = "form-group shadow-textarea";
            $(divTranslation).append(translation);
            let divButtons = ta.divFormGroupCreator();
            $(divButtons).append(submit, skip);
            let divMenu = ta.menuCreator();
            $(form).append(divWord);
            $(form).append(divDescription);
            $(form).append(divTranslation);
            $(form).append(divButtons);
            $("body").css("background-color", ta.backGroundColor());
            let header = ta.headerCreator();
            header.textContent = "Translation Annotation";
            $("body").append(divMenu, header);
            $("body").append(form);
        }
    }
    TranslationAnnotation.SERVLET_URL = "translationAnnotation.jsp";
    TranslationAnnotation.REST_URL = "nextExample.jsp";
    tasks.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "tasks.TranslationAnnotation";
})(tasks || (tasks = {}));
tasks.TranslationAnnotation.main(null);
