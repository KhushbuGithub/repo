var fullname:string;
console.log(fullname);
 fullname="Khush";
 console.log(fullname);

 var age:number=28;
 console.log(age);
  
 var isMarried:boolean =true;
 console.log(isMarried);

 var box:null=null;
 console.log(box);
 box=undefined;
 console.log(box);
  
 var work:undefined;
 work=undefined;

 var lastname="Shine";

 var firstname:any;
 firstname="Ram";
 firstname=5;
 firstname=true;
 firstname=undefined;
 firstname=null;
 console.log(firstname);
  
 function firstfunction(){
     console.log("first function");
 }
firstfunction();

function second(): string {
    return "john";
}

var nameValue=second();

console.log(nameValue);

var names:string[]=["raman","monu","ramy"];
console.log(names);

 var month:[string,number]=["November",3];
 console.log(month);

 var number:string|number=67;
 console.log(number);

 enum days{"Sunday"="Sunday","Monday"="Monday","Tuesday"="Tuesday"}
 console.log(days);