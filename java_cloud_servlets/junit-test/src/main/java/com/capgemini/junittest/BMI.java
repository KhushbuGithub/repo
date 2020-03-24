package com.capgemini.junittest;

public class BMI {

	public double calculateBmi(double height, double weight) {
		return weight / (height * height);
	}

	public String getBmiResult(double res) {
		if (res < 18.5) {
			return "Under Weight";
		} else if (res >= 18.5 && res < 25) {
			return "Normal";
		} else if (res >= 25 && res < 35) {
			return "Over Weight";
		} else {
			return "Obesity";
		}
	}

}
