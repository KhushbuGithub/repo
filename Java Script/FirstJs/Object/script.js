var personObject={
    firstName:"John",
    lastName:"Mikel",
    age:45
}

console.log(personObject.firstName);
console.log(personObject.lastName);
console.log(personObject.age);

var student= new Object();

student.firstName="John";
student.lastName="Mikel";
console.log(student);

var employee ={
    fullname:"Shree",
    contact:[9000000,700000000],
    address:{
        street: "BTM",
        pincode:78907890
    }
}
console.log(employee.address.street);
console.log(employee.address.pincode);
console.log(employee.contact);