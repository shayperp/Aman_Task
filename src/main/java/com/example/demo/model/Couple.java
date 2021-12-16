package com.example.demo.model;

import com.example.demo.Person;

public class Couple {
	 private Person one ;
	 private Person two;
	 private int gradeMatch;
	 
	 public Person getOne() {
		return one;
	}

	public void setOne(Person one) {
		this.one = one;
	}

	public Person getTwo() {
		return two;
	}

	public void setTwo(Person two) {
		this.two = two;
	}

	public int getGradeMatch() {
		return gradeMatch;
	}

	public void setGradeMatch(int gradeMatch) {
		this.gradeMatch = gradeMatch;
	}


	public Couple(Person one, Person two, int gradeMatch) {
		super();
		this.one = one;
		this.two = two;
		this.gradeMatch = gradeMatch;
	}
	
	
 
	 public String toString(){//overriding the toString() method  
		  return one.getFullName()+" "+two.getFullName()+" "+this.gradeMatch ;  
		 }

	
	


	}
