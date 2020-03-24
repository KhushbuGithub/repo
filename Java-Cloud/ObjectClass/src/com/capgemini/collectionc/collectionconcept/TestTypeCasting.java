package com.capgemini.collectionc.collectionconcept;

public class TestTypeCasting implements TypeCasting {
	public static void main(String[] args) {
		TypeCasting t=new TestTypeCasting();
		TestTypeCasting c= (TestTypeCasting)t;
		c.speed();
		System.out.println(t.hashCode());
		System.out.println(t.getClass());
		System.out.println(t.toString());
	}

	@Override
	public void speed() {
		// TODO Auto-generated method stub
		
	}

}
