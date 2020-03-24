package com.capgemini.collectionc.collectionconcept;

import java.util.Arrays;

public class MyArrayList<Any> {
	private static final int INIT_SIZE=2;
	private Any[] internalArray;
	private int arraysize;
	
	 MyArrayList() {
		this(INIT_SIZE);
	}
    MyArrayList(int size){
    	if(size<0)
    		throw new IllegalArgumentException("size cannot be zero");
    	internalArray= (Any[]) new Object[size];
    }
    public boolean add(Any a) {
    	checkCapacity(arraysize);
    	internalArray[arraysize++]=a;
    	return true;
    }
   
     private void checkCapacity(int size) {
    	if(size==internalArray.length) {
    		int previousSize=internalArray.length;
    		int newSize= previousSize*2;
    		internalArray=Arrays.copyOf(internalArray,newSize);
    	}
    }
     
    public boolean remove(int index) {
    	if(index<0||index>arraysize) {
    		throw new IllegalArgumentException("write correct index");
    	}
    	int number=arraysize-index-1;
    	if(number>0) {
    		System.arraycopy(internalArray, index+1, internalArray, index, number);
    		internalArray[--arraysize]= null;
    		
    	}
		return true;
    }
     
     
     
	@Override
	public String toString() {
		return Arrays.toString(internalArray);
	}
	public void details() {
		for (int i = 0; i < internalArray.length; i++) {
			System.out.println(internalArray[i]);
		}
	}
    
}
