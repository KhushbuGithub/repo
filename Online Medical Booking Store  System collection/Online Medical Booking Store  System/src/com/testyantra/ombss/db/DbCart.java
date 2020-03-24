package com.testyantra.ombss.db;

import java.util.LinkedList;
import java.util.TreeMap;

public class DbCart {

	public static int flag2 = 10;
	public static int temp2 ;
	
	@SuppressWarnings("rawtypes")
	public static TreeMap<Integer, LinkedList> cartDb = new TreeMap<Integer, LinkedList>();

	@SuppressWarnings({ "rawtypes", "unused" })
	public  static boolean cartDb( LinkedList ll) {

		boolean isSet = false;
		if (ll != null) {
			//cartDb = new TreeMap<Integer,LinkedList>();
			cartDb.put(flag2, ll);
			LinkedList ty =  cartDb.get(flag2);
			temp2 = flag2;

			//System.out.println(ty);
			flag2++;
			isSet = true;
		}
		return isSet;
	}//end of userDb()

}
