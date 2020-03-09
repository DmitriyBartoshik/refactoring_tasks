package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;
import java.util.Date;

public class User {

	private Date dateOfBirth;

	private String surName;

	private boolean booleanAdmin;

	private User[] subordinateArray;

	private int iRating;

	public User(String surName) {
		super();
		this.surName = surName;
	}

	@Override
	public String toString() {
		return "User [dateOfBirth=" + dateOfBirth + ", surName=" + surName + ", booleanAdmin=" + booleanAdmin + ", subordinateArray="
				+ Arrays.toString(subordinateArray) + ", iRating=" + iRating + "]";
	}

}
