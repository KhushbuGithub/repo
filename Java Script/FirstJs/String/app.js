var fullname="John Smith";
console.log(fullname.toUpperCase());
console.log(fullname.toLowerCase());
console.log(fullname.length);
var names= fullname.split(" ");
console.log(names);
console.log(fullname.indexOf("Smith"));
console.log(fullname.search(new RegExp("Smith")));
console.log(fullname.includes("Smith"));
fullname=fullname.replace("Smith","Mike");
console.log(fullname);
console.log(fullname.substr(0,4));