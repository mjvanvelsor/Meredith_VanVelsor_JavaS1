package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your age?");

        int age = Integer.parseInt(myScanner.nextLine());

        if (age < 14) {
            System.out.println("What grade are you in?");
            String grade = myScanner.nextLine();
            System.out.println("Wow! " + grade + " grade - that sounds exciting!");

        } else if (age >= 14 && age <= 18) {
            System.out.println("Are you planning on going to college?");
            String collegeYes = myScanner.nextLine();

            if (collegeYes.equals("yes")) {
                System.out.println("What college?");
                String school = myScanner.nextLine();
                System.out.println(school + " is a great school!");

            } else if (collegeYes.equals("no")){
                    System.out.println("What do you want to do after high school?");
                    String plans = myScanner.nextLine();
                    System.out.println("Wow, " + plans + " sounds like a plan!");
                }

            } else {
                System.out.println("What is your job?");
                String job = myScanner.nextLine();
                System.out.println(job + " sounds like a great job!");
            }

//Less than 14: Ask what grade they're in and then prints "Wow! [user answer] grade - that
// sounds exciting!"
//Between 14 and 18 (inclusive): Ask if they're planning to go to college.  If the answer is
// "yes" (all lowercase), ask what college and then print "[user answer] is a great school!".
// If the answer is "no" (all lowercase), ask what they want to do after high school, then print
// "Wow,  sounds like a plan!"
//Greater than 18: Ask what their job is, then print "[user answer] sounds like a great job!"

        }
    }
