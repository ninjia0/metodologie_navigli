/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class RandomPageChooser {
        constructor() {
            if (this.li === undefined)
                this.li = null;
            this.li = ([]);
            /* add */ (this.li.push(RandomPageChooser.web1) > 0);
            /* add */ (this.li.push(RandomPageChooser.web2) > 0);
            /* add */ (this.li.push(RandomPageChooser.web3) > 0);
            /* add */ (this.li.push(RandomPageChooser.web4) > 0);
            /* add */ (this.li.push(RandomPageChooser.web5) > 0);
            /* add */ (this.li.push(RandomPageChooser.web6) > 0);
            /* add */ (this.li.push(RandomPageChooser.web7) > 0);
        }
        getRandomPage() {
            let rand = ((Math.random() * (this.li.length + 1)) | 0);
            console.info(rand);
            return this.li[rand];
        }
    }
    RandomPageChooser.web1 = "definitionAnnotation.html";
    RandomPageChooser.web2 = "myAnnotation.html";
    RandomPageChooser.web3 = "senseAnnotation.html";
    RandomPageChooser.web4 = "senseValidation.html";
    RandomPageChooser.web5 = "translationAnnotation.html";
    RandomPageChooser.web6 = "translationValidation.html";
    RandomPageChooser.web7 = "wordAnnotation.html";
    quickstart.RandomPageChooser = RandomPageChooser;
    RandomPageChooser["__class"] = "quickstart.RandomPageChooser";
})(quickstart || (quickstart = {}));
