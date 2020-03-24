var loginform=document.forms["loginform"];
var loginDetails={};

loginform.addEventListener("submit",(e)=>{
    e.preventDefault();
    console.log(loginform);
    console.log(document.getElementById("email").value);
    console.log(document.getElementById("password").value);
    loginDetails.email= document.getElementById("email").value;
    loginDetails.password= document.getElementById("password").value;
    console.log(loginDetails);
})
