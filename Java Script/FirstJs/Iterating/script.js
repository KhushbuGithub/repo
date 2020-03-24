var numbers=[13,56,78,80];

console.log("for loop")
 for(var i=0;i<numbers.length;i++){
     console.log(numbers[i]);
 }

console.log("for of loop")
 for(var i of numbers){
     console.log(i);
 }

 console.log("for each loop")
     numbers.forEach(num=>{
         console.log(num);
     })

     console.log("for in loop")
     for(var i in numbers ){
         console.log(numbers[i]);
     }

var person={
    fullname:"Anu",
    age:28
}
console.log(person["fullname"]);
console.log(person["age"]);

for(var i in person){
    console.log(person[i])
}
 