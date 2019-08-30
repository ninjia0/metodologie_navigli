/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var tasks;
(function (tasks) {
    class SenseValidation {
        static main(args) {
            let sv = new tasks.BasicTaskHtml();
            sv.loginCheck();
            let form = sv.formCreator();
            form.action = SenseValidation.SERVLET_URL;
            let explanation = sv.paragraphCreator();
            let phrase = sv.labelCreator();
            let hiddenInput = sv.hiddenInputCreator();
            let checkbox = sv.checkboxCreator();
            checkbox.setAttribute("data-size", "lg");
            checkbox.name = "answer";
            let sense = sv.paragraphCreator();
            $(sense).css("font-size", "20px");
            let submit = sv.submitButtonCreator();
            submit.name = "submit_button";
            submit.value = "Next";
            let skip = sv.submitButtonCreator();
            skip.name = "skip_button";
            skip.value = "Skip";
            $(skip).css("float", "right");
            $.getJSON(SenseValidation.REST_URL, "task=SENSE_VALIDATION", ((phrase, sense, hiddenInput, explanation) => {
                return (result, a, ctx) => {
                    let json = result;
                    let word = (json["word"]);
                    let ex = (json["example"]);
                    let wsense = (json["sense"]);
                    $(phrase).text(ex);
                    $(explanation).text("Is the word " + word + "\'s sense is correct?");
                    sense.textContent = wsense;
                    hiddenInput.value = "word: " + word + ", example: " + ex + ", sense: " + wsense;
                    return null;
                };
            })(phrase, sense, hiddenInput, explanation));
            let divExplanation = sv.divCreator();
            divExplanation.className = "row align-items-center col-3-md";
            $(divExplanation).append(explanation, hiddenInput);
            let divPhrase = sv.divCreator();
            divPhrase.className = "row align-items-center col-3-md";
            $(divPhrase).append(phrase);
            let divCheckbox = sv.checkboxDivCreator();
            divCheckbox.className = "row align-items-center checkbox col-3-md";
            $(divCheckbox).css("border", "None");
            $(divCheckbox).append(checkbox, sense);
            let divAll = sv.divCreator();
            divAll.className = "container";
            $(divAll).append(divExplanation, divPhrase);
            $(divAll).append(divCheckbox);
            $(divAll).css("border", "ridge 1px");
            let divButtons = sv.divFormGroupCreator();
            $(divButtons).append(submit, skip);
            let header = sv.headerCreator();
            header.textContent = "Sense Validation";
            $(form).append(divAll);
            $(form).append(divButtons);
            $("body").css("background-color", sv.backGroundColor());
            $("body").append(sv.menuCreator(), header);
            $("body").append(form);
        }
    }
    SenseValidation.SERVLET_URL = "senseValidation.jsp";
    SenseValidation.REST_URL = "nextExample.jsp";
    tasks.SenseValidation = SenseValidation;
    SenseValidation["__class"] = "tasks.SenseValidation";
})(tasks || (tasks = {}));
tasks.SenseValidation.main(null);
