package com.capgemini.springcore.book;

import lombok.Data;

@Data
public class Author  implements Story{
	private String name;
	private String penname;
	@Override
	public void tellstory() {
    System.out.println("Story-Panchtantra");		
	}

}
