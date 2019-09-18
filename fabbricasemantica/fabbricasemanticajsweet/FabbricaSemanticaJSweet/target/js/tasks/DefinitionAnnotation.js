/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var tasks;
(function (tasks) {
    class DefinitionAnnotation {
        static main(args) {
            let da = new tasks.BasicTaskHtml();
            da.loginCheck();
            let form = da.formCreator();
            form.action = DefinitionAnnotation.SERVLET_URL;
            let word = da.paragraphCreator();
            let hiddenInput = da.hiddenInputCreator();
            word.className = "form-control-plaintext";
            $(word).css("float", "left");
            $(word).css("word-wrap", "break-word");
            let translation = da.textAreaCreator();
            translation.className = "md-textarea form-control";
            translation.placeholder = "Given a word and hyperonym write the definition in your language... ";
            translation.id = "form24";
            translation.rows = 3;
            let submit = da.submitButtonCreator();
            submit.name = "submit_button";
            submit.value = "Next";
            submit.disabled = true;
            let skip = da.submitButtonCreator();
            skip.name = "skip_button";
            skip.value = "Skip";
            $(skip).css("float", "right");
            da.emptyhandler(translation, submit);
            $.getJSON(DefinitionAnnotation.REST_URL, "task=DEFINITION_ANNOTATION", ((hiddenInput, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let oword = (json["word"]);
                    let ohypernym = (json["hypernym"]);
                    $(word).text(oword + "---" + ohypernym);
                    hiddenInput.value = "word: " + oword + ", hypername: " + ohypernym;
                    return null;
                };
            })(hiddenInput, word));
            let divDescription = da.divCreator();
            divDescription.className = "col-3 col-form-label mr-2";
            $(divDescription).append(word, hiddenInput);
            let divTranslation = da.divFormGroupCreator();
            divTranslation.className = "col-8 md-form amber-textarea active-amber-textarea-2";
            $(divTranslation).append(translation);
            let dido = da.divCreator();
            dido.className = "form-group row";
            $(dido).append(divDescription, divTranslation);
            let divButtons = da.divFormGroupCreator();
            $(divButtons).append(submit, skip);
            let header = da.headerCreator();
            header.textContent = "Definition Annotation";
            $(form).append(dido);
            $(form).append(divButtons);
            $("body").css("background-color", da.backGroundColor());
            $("body").append(da.menuCreator(), header);
            $("body").append(form);
        }
    }
    DefinitionAnnotation.SERVLET_URL = "definitionAnnotation.jsp";
    DefinitionAnnotation.REST_URL = "nextExample.jsp";
    tasks.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "tasks.DefinitionAnnotation";
})(tasks || (tasks = {}));
tasks.DefinitionAnnotation.main(null);
