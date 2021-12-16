package com.example.demo;

public abstract class Person {
    protected String prefferGender;
    protected String fullName;
    protected String gender;
    protected int age;
    protected String career;
    protected String dominantHabbit;

    protected int maxPartnerAge;
    protected String prefferPartnerCareer;
    protected String prefferPartnerHabbit;

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getCareer() {
        return career;
    }

    public String getDominantHabbit() {
        return dominantHabbit;
    }

    public String getPrefferGender() {
        return prefferGender;
    }

    public int getMaxPartnerAge() {
        return maxPartnerAge;
    }

    public String getPrefferPartnerCareer() {
        return prefferPartnerCareer;
    }

    public String getPrefferPartnerHabbit() {
        return prefferPartnerHabbit;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setDominantHabbit(String dominantHabbit) {
        this.dominantHabbit = dominantHabbit;
    }

    public void setPrefferGender(String prefferGender) {
        this.prefferGender = prefferGender;
    }

    public void setMaxPartnerAge(int maxPartnerAge) {
        this.maxPartnerAge = maxPartnerAge;
    }

    public void setPrefferPartnerCareer(String prefferPartnerCareer) {
        this.prefferPartnerCareer = prefferPartnerCareer;
    }

    public void setPrefferPartnerHabbit(String prefferPartnerHabbit) {
        this.prefferPartnerHabbit = prefferPartnerHabbit;
    }

    public Person(String fullName, String gender, int age, String career, String dominantHabbit, String prefferGender,
                  int maxPartnerAge, String prefferPartnerCareer, String prefferPartnerHabbit) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.career = career;
        this.dominantHabbit = dominantHabbit;
        this.prefferGender = prefferGender;
        this.maxPartnerAge = maxPartnerAge;
        this.prefferPartnerCareer = prefferPartnerCareer;
        this.prefferPartnerHabbit = prefferPartnerHabbit;
    }


}

