/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var tasks;
(function (tasks) {
    /**
     * this interface provides all the functions that used in different tasks
     * @class
     */
    class BasicTaskHtml {
        backGroundColor() {
            return "rgba(80,38,107,0.46)";
        }
        /**
         *
         * @return {HTMLFormElement} a form with post action and bootstrap container
         */
        formCreator() {
            let form = document.createElement("form");
            form.method = "POST";
            form.className = "container center_div";
            return form;
        }
        /**
         *
         * @return {HTMLHeadingElement} head tag for every html page
         */
        headerCreator() {
            let h1tag = document.createElement("h1");
            h1tag.className = "h1 text-center";
            $(h1tag).css("margin-top", "15px");
            $(h1tag).css("margin-bottom", "100px");
            return h1tag;
        }
        /**
         *
         * @return {HTMLLabelElement} label element
         */
        labelCreator() {
            let label = document.createElement("label");
            label.className = "form-control-plaintext";
            $(label).css("font-weight", "bold");
            return label;
        }
        /**
         *
         * @return {HTMLTextAreaElement} text area
         */
        textAreaCreator() {
            let ta = document.createElement("textarea");
            ta.name = "translation";
            ta.placeholder = "Write the translation here...";
            return ta;
        }
        /**
         *
         * @return {HTMLInputElement} a submit button for form submit
         */
        submitButtonCreator() {
            let button = document.createElement("input");
            button.className = "btn btn-primary btn-rounded";
            button.type = "submit";
            return button;
        }
        /**
         *
         * @return {HTMLDivElement} div html element
         */
        divFormGroupCreator() {
            let divel = document.createElement("div");
            divel.className = "form-group";
            return divel;
        }
        /**
         *
         * @return {HTMLDivElement} return div element with no class name
         */
        divCreator() {
            let divel = document.createElement("div");
            return divel;
        }
        /**
         *
         * @return {HTMLAnchorElement} return a link element
         */
        aCreator() {
            let a = document.createElement("a");
            a.className = "dropdown-item";
            return a;
        }
        /**
         *
         * @return {HTMLButtonElement} a button for dropdown menu
         */
        buttonCreator() {
            let btn = document.createElement("button");
            btn.className = "btn btn-secondary";
            btn.setAttribute("data-toggle", "dropdown");
            btn.type = "button";
            btn.textContent = "Menu";
            btn.setAttribute("aria-haspopup", "true");
            btn.setAttribute("aria-expanded", "false");
            $(btn).css("margin", "10px");
            return btn;
        }
        /**
         *
         * @return {HTMLParagraphElement} a text paragraph tag
         */
        paragraphCreator() {
            let p = document.createElement("p");
            return p;
        }
        /**
         *
         * @return {HTMLInputElement} input with type checkbox
         */
        checkboxCreator() {
            let checkbox = document.createElement("input");
            checkbox.setAttribute("data-toggle", "toggle");
            checkbox.type = "checkbox";
            checkbox.className = "form-check-input";
            checkbox.setAttribute("data-size", "xs");
            checkbox.setAttribute("data-on", "Yes");
            checkbox.setAttribute("data-off", "No");
            checkbox.setAttribute("data-onstyle", "primary");
            return checkbox;
        }
        /**
         *
         * @return {HTMLDivElement} div element for checkboxes
         */
        checkboxDivCreator() {
            let divCheckbox = document.createElement("div");
            divCheckbox.className = "checkbox col-5-md";
            $(divCheckbox).css("position", "50%");
            $(divCheckbox).css("border", "solid 0.5px blue");
            $(divCheckbox).css("border-radius", "5px");
            $(divCheckbox).css("margin-bottom", "5px");
            return divCheckbox;
        }
        /**
         *
         * @return {HTMLInputElement} hidden input tag
         */
        hiddenInputCreator() {
            let input = document.createElement("input");
            input.type = "hidden";
            input.name = "hidden";
            return input;
        }
        /**
         *
         * @return {HTMLDivElement} div element with all login and logout button
         */
        menuCreator() {
            let divMenu = this.divCreator();
            divMenu.className = "dropdown";
            let menuButton = this.buttonCreator();
            divMenu.appendChild(menuButton);
            let divList = this.divCreator();
            divList.className = "dropdown-menu";
            let home = this.aCreator();
            home.href = "home.html";
            home.textContent = "Home Page";
            let logout = this.aCreator();
            logout.href = "logout.jsp";
            logout.textContent = "Log Out";
            $(divList).append(home, logout);
            divMenu.appendChild(divList);
            return divMenu;
        }
        /**
         * if the given textarea is empty that disable the given submit button
         * @param {HTMLTextAreaElement} translation textarea element that has to be checked if it is empty
         * @param {HTMLInputElement} submit button element that has to be disable thile textarea is empty
         */
        emptyhandler(translation, submit) {
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
        /**
         * check if the user has already logged in
         */
        loginCheck() {
            $.getJSON(BasicTaskHtml.LOGIN_CHECK, (result, a, ctx) => {
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(result.toString(), "false")) {
                    $(location).attr("href", BasicTaskHtml.LOGIN_PAGE);
                }
                return null;
            });
        }
        /**
         * this function takes array of string for label element and create array.length label with div
         * element finally save all in a list
         * @param {Array} text of String array for label element's context
         * @return {HTMLDivElement[]} list of div elements
         */
        inputLabelGenerator(...text) {
            let inputlabel = ([]);
            for (let i = 0; i < text.length; i++) {
                {
                    let div = document.createElement("div");
                    div.className = "custom-control custom-checkbox";
                    $(div).css("position", "50%");
                    $(div).css("border", "solid 0.5px blue");
                    $(div).css("border-radius", "5px");
                    $(div).css("margin-bottom", "5px");
                    let la = document.createElement("label");
                    la.setAttribute("font-weight", "bold");
                    la.className = "custom-control-label";
                    la.setAttribute("for", "labelinput-" + i);
                    la.textContent = text[i];
                    let inp = document.createElement("input");
                    inp.type = "checkbox";
                    inp.value = text[i];
                    inp.className = "custom-control-input";
                    inp.setAttribute("id", "labelinput-" + i);
                    inp.name = "userchoice";
                    $(div).append(inp, la);
                    /* add */ (inputlabel.push(div) > 0);
                }
                ;
            }
            return inputlabel;
        }
    }
    BasicTaskHtml.LOGIN_PAGE = "login.html";
    BasicTaskHtml.LOGIN_CHECK = "isLoggedIn.jsp";
    tasks.BasicTaskHtml = BasicTaskHtml;
    BasicTaskHtml["__class"] = "tasks.BasicTaskHtml";
})(tasks || (tasks = {}));
