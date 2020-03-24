package com.capgemini.log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Demo {
	static Logger log = LogManager.getLogger("Khush");

	public static void main(String[] args) {
		log.trace("I am a trace method");
		log.debug("I am a debug method");
		log.info("I am a info method");
		log.warn("I am a warn method");
		log.error("I am a error method");
		log.fatal("I am a fatal method");

	}

}
