var fullName:string;
console.log(fullName);

fullName="John Smith";
//fullName=30 -> error

var age : number=24;
console.log(age);

var isMarried : boolean =true;
console.log(isMarried);

var futurePlan : undefined;
console.log(futurePlan);
futurePlan=null;
console.log(futurePlan);

var nextPlan : null;
console.log(nextPlan);
nextPlan=undefined;
console.log(nextPlan);

var firstName:any;
firstName="john";
firstName=30;
firstName=true;
firstName=null;
firstName=undefined;

console.log(firstName); 

function first() :void {
    console.log("First Function")
}
first();

function sec() :string{
    return "Chandu";
}

var nameValue = sec();
console.log(nameValue);

//arrays
var names : string[]=["chandra","sekhar","vidyam",null,undefined];
console.log(names);

//tuples
var month :[string,number]=["january",1];
console.log(month);
//union

var myNum:string | number ="Three";
console.log(myNum);

myNum=30;
console.log(myNum);

enum days {"Monday"="mon","Tuesday"="tues","Wednesday"="wed"};
console.log(days.Tuesday);
console.log(days.Monday);
