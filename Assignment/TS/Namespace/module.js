var Person;
(function (Person) {
    Person.newName = "Khush";
    function getName() {
        console.log(Person.newName);
    }
    Person.getName = getName;
})(Person || (Person = {}));
///<reference path="namespace.ts"/>
console.log(Person.newName);
Person.getName();
