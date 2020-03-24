package com.capgemini.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

class MyFriendsTest {

	static MyFriends m = null;

	@BeforeAll
	static void createObject() {
		m = new MyFriends();
	}

	@RepeatedTest(5)
	void getNametest(RepetitionInfo info) {
		int repCount = info.getCurrentRepetition();
		String name = m.getName();
		if (repCount <= 4) {
			assertNotNull(name);
		} else {
			assertNull(name);
		}

	}

}
