var fullname;
console.log(fullname);
fullname = "Khush";
console.log(fullname);
var age = 28;
console.log(age);
var isMarried = true;
console.log(isMarried);
var box = null;
console.log(box);
box = undefined;
console.log(box);
var work;
work = undefined;
var lastname = "Shine";
var firstname;
firstname = "Ram";
firstname = 5;
firstname = true;
firstname = undefined;
firstname = null;
console.log(firstname);
function firstfunction() {
    console.log("first function");
}
firstfunction();
function second() {
    return "john";
}
var nameValue = second();
console.log(nameValue);
var names = ["raman", "monu", "ramy"];
console.log(names);
var month = ["November", 3];
console.log(month);
var number = 67;
console.log(number);
var days;
(function (days) {
    days["Sunday"] = "Sunday";
    days["Monday"] = "Monday";
    days["Tuesday"] = "Tuesday";
})(days || (days = {}));
console.log(days);
