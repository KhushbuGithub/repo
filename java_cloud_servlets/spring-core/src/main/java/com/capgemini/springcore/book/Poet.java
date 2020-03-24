package com.capgemini.springcore.book;

import org.springframework.stereotype.Component;


public class Poet implements Story {

	@Override
	public void tellstory() {
    System.out.println("Poem-Jingle Bell");		
	}

}
