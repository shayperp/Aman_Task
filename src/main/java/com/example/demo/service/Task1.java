package com.example.demo.service;

import com.example.demo.Person;
import com.example.demo.model.Couple;
import com.example.demo.model.Female;
import com.example.demo.model.Male;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task1 {
    ArrayList<Person> prefferMale = new ArrayList();
    ArrayList<Person> prefferFemale = new ArrayList();
    ArrayList<Couple> matching = new ArrayList();
    Logger logger = Logger.getLogger(this.getClass().getName());

    public void run() {
        System.out.println("please put the file name : ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        readFile(path);
        matching();
        matching.sort(Comparator.comparingInt(Couple::getGradeMatch).reversed());
        printMatching();

    }

    private void printMatching() {
        logger.log(Level.INFO, Arrays.toString(matching.toArray()));
    }


    void matching() {
        for (Person p : prefferMale) {
            for (Person otherP : prefferFemale)
                if (p.getGender().equals(otherP.getPrefferGender())) {
                    matching.add(new Couple(p, otherP, matchGrade(p, otherP)));
                }

        }

    }

    int matchGrade(Person one, Person two) {
        int grade = 0;
        if (one.getAge() <= two.getMaxPartnerAge())
            if (one.getMaxPartnerAge() >= two.getAge())
                grade++;

        if (one.getCareer().equals(two.getPrefferPartnerCareer()))
            if (two.getCareer().equals(one.getPrefferPartnerCareer()))
                grade++;

        if (one.getDominantHabbit().equals(two.getPrefferPartnerHabbit()))
            if (two.getDominantHabbit().equals(one.getPrefferPartnerHabbit()))
                grade++;

        return grade;
    }


    public void readFile(String fileName) {
        try {
            File f = new File(fileName);
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split(",");
                String fullName = details[0].trim();
                String gender = details[1].trim();
                int age = Integer.parseInt(details[2].trim());
                String career = details[3].trim();
                String dominantHabbit = details[4].trim();
                String prefferGender = details[5].trim();
                int maxPartnerAge = Integer.parseInt(details[6].trim());
                String prefferPartnerCareer = details[7].trim();
                String prefferPartnerHabbit = details[8].trim();
                String otherAttrbute = details[9].trim();
                if (prefferGender.equals("Male")) {//attract to man
                    prefferMale.add(new Female(fullName, gender, age, career, dominantHabbit, prefferGender, prefferPartnerHabbit, maxPartnerAge, prefferPartnerCareer, otherAttrbute));
                } else { // Attract to women
                    prefferFemale.add(new Male(fullName, gender, age, career, dominantHabbit, prefferGender, maxPartnerAge, prefferPartnerHabbit, prefferPartnerCareer, Integer.parseInt(otherAttrbute)));
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

