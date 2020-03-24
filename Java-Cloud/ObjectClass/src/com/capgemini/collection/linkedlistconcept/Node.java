package com.capgemini.collection.linkedlistconcept;

public class Node<Any> {
	Node<Any> prev;
	Any data;
	Node<Any> next;
	
	 Node(Any data){
		 this(null,data,null);
	 }

	public Node(Node<Any> prev, Any data, Node<Any> next) {
		this.prev = prev;
		this.data = data;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node ["+ " data=" + data + ", next=" + next + "]";
	}
	

}
