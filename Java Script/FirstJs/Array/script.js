var names=["John","Mickel"];
var fruits=new Array("Orange","Pear");
names[2]="Mona";
fruits[2]="Mango";
console.log(names);
console.log(fruits);

names.push("Ram");//add element at the last
console.log(names);

names.pop();// remove the last element
console.log(names);

names.unshift("divya");//add element at first
console.log(names);

names.shift();// delete the first element
console.log(names);

names.splice(0,1,"Shree");  // to replace the element
console.log(names);

console.log(names.indexOf("Mona"));//to get the index value

var namesCopy= names.slice(0,2);// it is like clone method ,copy the elements 
console.log(names);
console.log(namesCopy);

var fruitsData= fruits.map((fruits) => {
    return fruits.concat("fruit");
})
console.log(fruitsData);

var num=[12,13,14,15,18];
var numCopy= num.filter((number) => {
    if(number%2 == 0){
        return number;
    }
})

console.log(numCopy);
