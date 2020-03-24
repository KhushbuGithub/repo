var person={
    firstname:"Khush",
    lastname:"Khush",
    concat:function(){
        console.log(this);
        this.fullname=this.firstname+this.lastname;
        function merge(){
            console.log(this);
        }
        merge();
    }
}
person.age=29;
console.log(person);
console.log(person.fullname);