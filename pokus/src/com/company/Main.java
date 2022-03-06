package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {

    public static List<Workout> myWorkout = new ArrayList<>();
    public static int newKcal;
    public static String typeWorkout;
    public static String newTime;
    public static Scanner scan = new Scanner(System.in);
    public static int j = 0;
    public static Map<Time, Integer> maap = new HashMap();
    public static Time time1;
    public static int allen;

    public static void main(String[] args) {
        chose();
    }

    static void chose() {
        int m;
        do {
            System.out.println(Thread.currentThread().getStackTrace().length);
            System.out.println("What would you like to do? 1 - new workout, 2 - edit workouts, 3 - list all workouts, 4 - create and or overwrite, 5 - exit");
            m = scan.nextInt();
            scan.nextLine();
            switch (m) {
                case 1 -> newWorkout();
                case 2 -> editWorkout();
                case 3 -> writeOut();
                case 4 -> file();
                case 5 -> end();
            }
        } while (m != 5);
    }

    static void newWorkout() {
        System.out.println("What were you doing?");
        typeWorkout = scan.nextLine();
        System.out.println("How many kcal did you burn?");
        newKcal = scan.nextInt();
        scan.nextLine();
        System.out.println("When did you exercise? morning, noon or evening?");
        String timeStr = scan.nextLine();
        Time time = Time.valueOf(timeStr.toUpperCase(Locale.ROOT));
        myWorkout.add(new Workout(typeWorkout, newKcal, time));
        if (maap.containsKey(time)) {
            maap.put(time, maap.get(time) + newKcal);
        } else {
            maap.put(time, newKcal);
        }
    }

    static void writeOut() {
        int n = myWorkout.size();
        int all = 0;
        System.out.println("What part of the day do you want to count up?");
        String timeStr = scan.nextLine();
        Time time = Time.valueOf(timeStr.toUpperCase(Locale.ROOT));
        System.out.println("Workouts:");
        for (int i = 0; i < n; i++) {
            System.out.println(myWorkout.get(i).toString() + " id: " + i);
            all = all + myWorkout.get(i).getKcal();
        }
        System.out.println("----");
        System.out.println("Total calories throughout the whole day: " + all + " kcal");
        System.out.println("Average calories per workout: " + (all / n) + " kcal");
        System.out.println("You have burnt " + maap.get(time) + " kcal in the " + timeStr);
    }

    static void editWorkout() {
        System.out.println("Which workout by id would you like to edit?");
        int b = scan.nextInt();
        scan.nextLine();
        if (b < myWorkout.size() && !(b < 0)) {
            System.out.println("Type in kcal");
            int huh = scan.nextInt();
            scan.nextLine();
            System.out.println("Type in time");
            String timee = scan.nextLine();
            time1 = Time.valueOf(timee.toUpperCase(Locale.ROOT));
            myWorkout.get(b).setTime(time1);
            System.out.println("Type in workout");
            myWorkout.get(b).setWorkout(scan.nextLine());
            if (time1 != myWorkout.get(b).getTime()) {
                maap.put(myWorkout.get(b).getTime(), maap.get(myWorkout.get(b).getKcal()) - myWorkout.get(b).getKcal());
                maap.put(time1, maap.get(time1) + huh);
            } else {
                maap.put(time1, maap.get(time1) - myWorkout.get(b).getKcal() + huh);
            }
            myWorkout.get(b).setKcal(huh);
        } else {
            System.out.println("Sorry, wrong number");
        }
    }

    static void file(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Mattias\\IdeaProjects\\zkouskatestusus\\pokus\\src\\com\\myWorkouts.txt"));
            System.out.println("Whic time do you want to write into the file?");
            String timey = scan.nextLine();
            Time time = Time.valueOf(timey.toUpperCase(Locale.ROOT));
            bw.write("Workouts:\n");
            for (int i = 0; i < myWorkout.size(); i++) {
                bw.write(myWorkout.get(i).toString() + " id: " + i +"\n");
                allen = allen + myWorkout.get(i).getKcal();
            }
            bw.write("You have burnt " + maap.get(time) + " kcal in the " + time + "\n");
            bw.write("Total calories: "+allen+" kcal.\n");
            bw.write("Average calories per workout: " + (allen / myWorkout.size()) + " kcal\n");
            System.out.println("Thats done!");
            bw.close();
        }catch (Exception ex){
            return;
        }
    }

    static void end() {
        System.out.println("Thanks bye! SLAVA UKRAINI");
    }

}
