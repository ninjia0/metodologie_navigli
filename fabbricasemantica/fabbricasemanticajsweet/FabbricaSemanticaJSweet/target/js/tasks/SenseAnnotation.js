/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var tasks;
(function (tasks) {
    class SenseAnnotation {
        static main(args) {
            let sa = new tasks.BasicTaskHtml();
            sa.loginCheck();
            let form = sa.formCreator();
            form.action = SenseAnnotation.SERVLET_URL;
            let explanation = sa.paragraphCreator();
            let hidden = sa.hiddenInputCreator();
            let phrase = sa.labelCreator();
            explanation.className = "form-control-plaintext";
            let submit = sa.submitButtonCreator();
            submit.name = "submit_button";
            submit.value = "Next";
            let skip = sa.submitButtonCreator();
            skip.name = "skip_button";
            skip.value = "Skip";
            $(skip).css("float", "right");
            let divButtons = sa.divFormGroupCreator();
            $(divButtons).append(submit, skip);
            $.getJSON(SenseAnnotation.REST_URL, "task=SENSE_ANNOTATION", ((hidden, phrase, form, divButtons, explanation, sa) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sword = (json["word"]);
                    let sDescription = (json["description"]);
                    hidden.value = "word: " + sword + ", description: " + sDescription;
                    $(explanation).text("Choose the correct meaning of the word \"" + sword + "\"");
                    $(phrase).text(sDescription);
                    let sT = json["senses"].toString().split(",");
                    SenseAnnotation.inputlabel = sa.inputLabelGenerator(sT[0], sT[1], sT[2], sT[3]);
                    let divInputLabel = sa.divFormGroupCreator();
                    for (let index123 = 0; index123 < SenseAnnotation.inputlabel.length; index123++) {
                        let d = SenseAnnotation.inputlabel[index123];
                        {
                            $(divInputLabel).append(d);
                        }
                    }
                    $(form).append(divInputLabel);
                    $(form).append(divButtons);
                    return null;
                };
            })(hidden, phrase, form, divButtons, explanation, sa));
            let divExplanation = sa.divCreator();
            $(divExplanation).append(explanation, hidden);
            let divPhrase = sa.divCreator();
            $(divPhrase).append(phrase);
            let header = sa.headerCreator();
            header.textContent = "Sense Annotation";
            $(form).append(divExplanation);
            $(form).append(divPhrase);
            $(form).append(divButtons);
            $("body").css("background-color", sa.backGroundColor());
            $("body").append(sa.menuCreator(), header);
            $("body").append(form);
        }
    }
    SenseAnnotation.SERVLET_URL = "senseAnnotation.jsp";
    SenseAnnotation.REST_URL = "nextExample.jsp";
    SenseAnnotation.inputlabel = null;
    tasks.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "tasks.SenseAnnotation";
})(tasks || (tasks = {}));
tasks.SenseAnnotation.main(null);
