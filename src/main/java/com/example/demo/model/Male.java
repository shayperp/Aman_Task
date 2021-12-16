package com.example.demo.model;

import com.example.demo.Person;

public class Male extends Person {
	private int height;

	public Male(String fullName, String gender, int age, String career, String dominantHabbit, String prefferGender,
			int maxPartnerAge, String prefferPartnerCareer, String prefferPartnerHabbit, int height) {
		super(fullName, gender, age, career, dominantHabbit, prefferGender, maxPartnerAge, prefferPartnerCareer,
				prefferPartnerHabbit);
		this.height = height;
		// TODO Auto-generated constructor stub
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}


	

		}


