var fullName;
console.log(fullName);
fullName = "John Smith";
//fullName=30 -> error
var age = 24;
console.log(age);
var isMarried = true;
console.log(isMarried);
var futurePlan;
console.log(futurePlan);
futurePlan = null;
console.log(futurePlan);
var nextPlan;
console.log(nextPlan);
nextPlan = undefined;
console.log(nextPlan);
var firstName;
firstName = "john";
firstName = 30;
firstName = true;
firstName = null;
firstName = undefined;
console.log(firstName);
function first() {
    console.log("First Function");
}
first();
function sec() {
    return "Chandu";
}
var nameValue = sec();
console.log(nameValue);
//arrays
var names = ["chandra", "sekhar", "vidyam", null, undefined];
console.log(names);
//tuples
var month = ["january", 1];
console.log(month);
//union
var myNum = "Three";
console.log(myNum);
myNum = 30;
console.log(myNum);
var days;
(function (days) {
    days["Monday"] = "mon";
    days["Tuesday"] = "tues";
    days["Wednesday"] = "wed";
})(days || (days = {}));
;
console.log(days.Tuesday);
console.log(days.Monday);
