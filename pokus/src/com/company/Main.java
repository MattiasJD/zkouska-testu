package com.company;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        chose();
    }
    static void chose(){
        int m = 0;
        System.out.println("What would you like to do? 1 - new workout, 2 - edit workouts, 3 - list all workouts, 4 - list workouts by their time");
        m = scan.nextInt();
        scan.nextLine();
        switch (m){
            case 1 -> newWorkout();
            case 2 -> editWorkout();
            case 3 -> writeOut();
        }
    }

    public static List<Workout> myWorkout = new ArrayList<>();
    public static int newKcal;
    public static String typeWorkout;
    public static String newTime;
    public static Scanner scan = new Scanner(System.in);
    public static int j = 0;

    static void newWorkout(){
        System.out.println("What were you doing?");
        typeWorkout = scan.nextLine();
        System.out.println("How many kcal did you burn?");
        newKcal = scan.nextInt();
        scan.nextLine();
        System.out.println("When did you exercise? 1 - morning, 2 - noon, 3 - evening");
        newTime= scan.nextLine();
        int a = scan.nextInt();
        if(Time.){

        }
        myWorkout.add(new Workout(typeWorkout,newKcal,Time(a)));
        chose();
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
        chose();
    }
    static void editWorkout(){
        System.out.println("Which workout by id would you like to edit?");
        int b = scan.nextInt();
        if(b < myWorkout.size() && !(b < 0)){
            System.out.println("Type in kcal");
            myWorkout.get(b).setKcal(scan.nextInt());
            System.out.println("Type in time");
            /***myWorkout.get(b).setTime();***/
            System.out.println("Type in workout");
            myWorkout.get(b).setWorkout(scan.nextLine());
        }
        else{
            System.out.println("Sorry, wrong numbeer");
        }
        chose();
    }

}
