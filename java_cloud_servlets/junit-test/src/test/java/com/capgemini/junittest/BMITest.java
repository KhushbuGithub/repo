package com.capgemini.junittest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BMITest {

	@ParameterizedTest
	@MethodSource("getBmiValues")
	void getBmiResultTest(double value, String results) {
		BMI bmi = new BMI();
		String actual = bmi.getBmiResult(value);
		assertEquals(results, actual);
	}

	static Stream<Arguments> getBmiValues() {
		return Stream.of(Arguments.arguments(18.9, "Normal"),
				Arguments.arguments(15.9, "Under Weight"),
				Arguments.arguments(28.9, "Over Weight"),
				Arguments.arguments(58.9, "Obesity"));

	}

}
