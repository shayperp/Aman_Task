package com.example.demo.model;

import com.example.demo.Person;

public class Female extends Person {
	 String hairColor;

	public Female(String fullName, String gender , int age ,String career ,
				  String dominantHabbit, String prefferGender,String prefferPartnerHabbit,Integer maxPartnerAge, String prefferPartnerCareer, String hairColor ) {


		super(fullName,  gender,  age,  career,  dominantHabbit,  prefferGender,maxPartnerAge,  prefferPartnerCareer,  prefferPartnerHabbit); 
		this.hairColor = hairColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

}


