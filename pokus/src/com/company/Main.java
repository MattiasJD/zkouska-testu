package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static List<Workout> myWorkout = new ArrayList<>();
    public static int newKcal;
    public static String typeWorkout;
    public static String newTime;
    public static Scanner scan = new Scanner(System.in);
    public static int j = 0;

    public static void main(String[] args) {
        chose();
    }

    static void chose(){
        do {
            int m = 0;
            System.out.println(Thread.currentThread().getStackTrace().length);
            System.out.println("What would you like to do? 1 - new workout, 2 - edit workouts, 3 - list all workouts, 4 - list workouts by their time");
            m = scan.nextInt();
            scan.nextLine();
            switch (m) {
                case 1 -> newWorkout();
                case 2 -> editWorkout();
                case 3 -> writeOut();
                case 4 -> writeOutTime();
            }
        } while (true);
    }

    static void newWorkout(){
        System.out.println("What were you doing?");
        typeWorkout = scan.nextLine();
        System.out.println("How many kcal did you burn?");
        newKcal = scan.nextInt();
        scan.nextLine();
        System.out.println("When did you exercise? 1 - morning, 2 - noon, 3 - evening");
        String timeStr = scan.nextLine();
        Time time = Time.valueOf(timeStr.toUpperCase(Locale.ROOT));
        myWorkout.add(new Workout(typeWorkout,newKcal,time));
     //   chose();
    }

    static void writeOut(){
        int n = myWorkout.size();
        int all = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(myWorkout.get(i).toString()+" id: "+i);
            System.out.println("----");
            all = all + myWorkout.get(i).getKcal();
        }
        System.out.println("Totals calories: "+all+" kcal");
        System.out.println("Average calories per workout: "+(all/n)+" kcal");
    }
    static void editWorkout(){
        System.out.println("Which workout by id would you like to edit?");
        int b = scan.nextInt();
        scan.nextLine();
        if(b < myWorkout.size() && !(b < 0)){
            System.out.println("Type in kcal");
            myWorkout.get(b).setKcal(scan.nextInt());
            scan.nextLine();
            System.out.println("Type in time");
            String timee = scan.nextLine();
            Time time = Time.valueOf(timee.toUpperCase(Locale.ROOT));
            myWorkout.get(b).setTime(time);
            System.out.println("Type in workout");
            myWorkout.get(b).setWorkout(scan.nextLine());
        }
        else{
            System.out.println("Sorry, wrong numbeer");
        }
    }
    static void writeOutTime(){
        System.out.println("Which time do you want to see?");
        String bruh = scan.nextLine();
        Time time = Time.valueOf(bruh.toUpperCase(Locale.ROOT));
        for (int i = 0; i < myWorkout.size(); i++) {
            if(myWorkout.get(i).getTime() == time){
                System.out.println(myWorkout.get(i).toString()+" id: "+i);
            }
        }
    }

}
