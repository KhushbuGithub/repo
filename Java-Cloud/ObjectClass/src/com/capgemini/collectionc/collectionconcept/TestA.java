package com.capgemini.collectionc.collectionconcept;

import java.util.ArrayList;
import java.util.Arrays;

public class TestA {
	public static void main(String[] args) {
		
		int ar[]=new int[3];
		ar[0]=34;
		ar[1]=67;
		ar[2]=90;
		
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		System.out.println("----------------------------");
		ar=Arrays.copyOf(ar, 5);
		ar[3]=67;
		ar[4]=97;
		for (int i = 0; i < ar.length; i++) {
		   System.out.println(ar[i]);
		}
		
		
		
		
	}

}
