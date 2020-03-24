//regular function or named function
function add(val1,val2){
    console.log("sum"+val1+val2);//concatinating the string with number
    console.log("sum"+(val1+val2));  //grouping makes the number to add first the concatination 
}
add(34,45);

//fuction expression in js
var sub=function(val1, val2){
    console.log(val1-val2)
}
sub(45,5);

//IIFE
(function(val1,val2){
    console.log(val1*val2);
}(45,10));  //})(45,10)

//Call back function
var divide=(val1,val2) => {
    console.log(val1/val2);
}
divide(500,5);