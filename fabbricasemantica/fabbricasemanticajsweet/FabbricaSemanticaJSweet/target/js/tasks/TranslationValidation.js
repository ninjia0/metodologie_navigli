/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var tasks;
(function (tasks) {
    class TranslationValidation {
        static main(args) {
            let tv = new tasks.BasicTaskHtml();
            tv.loginCheck();
            let form = tv.formCreator();
            form.action = TranslationValidation.SERVLET_URL;
            let explanation = tv.paragraphCreator();
            explanation.className = "form-control-plaintext";
            $(explanation).css("float", "left");
            let description = tv.labelCreator();
            let hidden = tv.hiddenInputCreator();
            let submit = tv.submitButtonCreator();
            submit.name = "submit_button";
            submit.value = "Next";
            let skip = tv.submitButtonCreator();
            skip.name = "skip_button";
            skip.value = "Skip";
            $(skip).css("float", "right");
            let divButtons = tv.divFormGroupCreator();
            $(divButtons).append(submit, skip);
            $.getJSON(TranslationValidation.REST_URL, "task=TRANSLATION_VALIDATION", ((tv, hidden, form, divButtons, description, explanation) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sword = (json["word"]);
                    let sDescription = (json["description"]);
                    hidden.value = "word: " + sword + ", description: " + sDescription;
                    $(explanation).text("Choose the correct phrase for the word " + sword);
                    $(description).text(sDescription);
                    let sT = json["translations"].toString().split(",");
                    TranslationValidation.inputlabel = tv.inputLabelGenerator(sT[0], sT[1], sT[2], "niente di sopra e corretto");
                    let divInputLabel = tv.divFormGroupCreator();
                    for (let index124 = 0; index124 < TranslationValidation.inputlabel.length; index124++) {
                        let d = TranslationValidation.inputlabel[index124];
                        {
                            $(divInputLabel).append(d);
                        }
                    }
                    $(form).append(divInputLabel);
                    $(form).append(divButtons);
                    return null;
                };
            })(tv, hidden, form, divButtons, description, explanation));
            let divExplanation = tv.divCreator();
            $(divExplanation).append(explanation, hidden);
            let divPhrase = tv.divCreator();
            $(divPhrase).append(description);
            let header = tv.headerCreator();
            header.textContent = "Translation Validation";
            $(form).append(divExplanation);
            $(form).append(divPhrase);
            $("body").css("background-color", tv.backGroundColor());
            $("body").append(tv.menuCreator(), header);
            $("body").append(form);
        }
    }
    TranslationValidation.SERVLET_URL = "translationValidation.jsp";
    TranslationValidation.REST_URL = "nextExample.jsp";
    TranslationValidation.inputlabel = null;
    tasks.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "tasks.TranslationValidation";
})(tasks || (tasks = {}));
tasks.TranslationValidation.main(null);
