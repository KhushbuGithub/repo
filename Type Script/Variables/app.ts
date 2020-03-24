var fullname:string;
console.log(fullname);
 fullname="Jhon";
 console.log(fullname);

 var age:number=28;
 console.log(age);
  
 var isMarried:boolean =true;
 console.log(isMarried);

 var futureplan:null=null;
 console.log(futureplan);
 futureplan=undefined;
 console.log(futureplan);
  
 var work:undefined;
 work=undefined;

 var lastname="Mickel";

 var firstname:any;
 firstname="John";
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

var names:string[]=["ramesh","mahesh","ram"];
console.log(names);

 var month:[string,number]=["jan",3];
 console.log(month);

 var number:string|number=67;
 console.log(number);

 enum days{"mon"="monday","tues"="tuesday","wed"="wednesday"}
 console.log(days);