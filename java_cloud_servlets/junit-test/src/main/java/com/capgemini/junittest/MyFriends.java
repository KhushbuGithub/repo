package com.capgemini.junittest;

import java.util.ArrayList;

public class MyFriends {

	private ArrayList<String> al = new ArrayList<String>();

	public MyFriends() {
		al.add("ABCD");
		al.add("EFGH");
		al.add("IJKL");
		al.add("MNPO");
	}

	public String getName() {
		if (al.size() == 0) {
			return null;
		} else {
			return al.remove(0);
		}
	}

}
