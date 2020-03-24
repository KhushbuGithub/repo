var personObject={
    firstName:"Khush",
    lastName:"Khush",
    age:45
}

console.log(personObject.firstName);
console.log(personObject.lastName);
console.log(personObject.age);

var student= new Object();

student.firstName="Khush";
student.lastName="Khush";
console.log(student);

var employee ={
    fullname:"Singh",
    contact:[9000000,700000000],
    address:{
        street: "BTM",
        pincode:78907890
    }
}
console.log(employee.address.street);
console.log(employee.address.pincode);
console.log(employee.contact);