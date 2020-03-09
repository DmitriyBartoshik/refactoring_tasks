package com.epam.engx.cleancode.naming.task3;

public class H {

	// print some Harshad numbers
	public static void main(String[] args) {
		long maxHarshadNumber = 1000; // limit the seq of Harshad numbers
		for (int i = 1; i <= maxHarshadNumber; i++) {
			if (i % countSumNumber(i) == 0) {
				System.out.println(i);
			}
		}
	}

	private static int countSumNumber(int number) {
		int sum = 0;
		while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
		return sum;
	}

}
