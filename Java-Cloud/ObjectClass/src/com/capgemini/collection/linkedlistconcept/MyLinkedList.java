package com.capgemini.collection.linkedlistconcept;

import java.util.NoSuchElementException;

public class MyLinkedList<Any> {
	private Node<Any> first;
	private int size;

	MyLinkedList(){
		this.first=null;
	}
	public boolean add(Any a) {
		if(isEmpty()) {
			first=new Node<Any>(a);
		} else {
			Node<Any> temp=first;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=new Node(temp,a,null);
		}
		size++;
		return true;
	}
		 public boolean remove(Any o) {
			if(isEmpty()) {
				throw new NoSuchElementException("Element not Found");
			}
			if(first.data.equals(o)) {
				first=first.next;
				size--;
				return true;
			} else {
				Node<Any> current =first;
				while(current!=null && !current.data.equals(o)) {
					current= current.next;
				}
				if(current==null) {
					throw new NoSuchElementException("Element not Found");
				}
				if(current.next !=null) {
					current.next.prev=current.prev;
				}
				current.prev.next=current.next;
				size--;
				return true;

			}
		}

	
	private boolean isEmpty() {
		if(size==0) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "MyLinkedList [first=" + first + ", size=" + size + "]";
	}

}
