package com.capgemini.streamapi.stream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StreamApi_1 {
	
	
	public static void main(String[] args) {
		 Predicate<Integer> p = i -> ((i%2)==0);
			 System.out.println(p.test(12));
			 System.out.println(p.test(13));
			 
			 
			 Function<Integer, Integer> f= j->j*10;
			 System.out.println(f.apply(23));
			 System.out.println(f.apply(45));
			 
			 
			 Supplier<Person> s=() -> {
				 return new Person(12, "John");
			 };
			 
			 System.out.println(s.get().getAge());
			 System.out.println(s.get().getName());
			 System.out.println("---------------------------");
			 
			 Consumer<Person> c=j ->{
				 System.out.println(j.getAge());
				 System.out.println(j.getName());
			 };
			 c.accept(new Person(34, "Ram"));
			 c.accept(new Person(45, "Sia"));
		 }
	

}
