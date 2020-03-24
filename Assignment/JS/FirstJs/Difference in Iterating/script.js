
var names=[ ];
names[4]=29;
console.log(names);
for(var i of names){
    console.log(i);
}
console.log("------------for--------------")
for(var i=0;i<names.length;i++){
    console.log(names[i]);
}
console.log("for each")
var numbers=[12,20];
numbers["ramesh"]=30;
console.log(numbers);
console.log("for in");
for(var i in numbers){
    console.log(numbers[i]);
}
console.log("for of")
for (var i of numbers){
    console.log(i);
}
